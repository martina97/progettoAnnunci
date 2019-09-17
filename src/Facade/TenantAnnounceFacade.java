package Facade;

import bean.TenantAnnounceBean;
import Interfaces.Rules;
import Interfaces.RulesInterface;
import boundary.Main;
import dao.DBFunctions;
import entity.TenantAnnounce;

public class TenantAnnounceFacade {
    private TenantAnnounceBean tenantAnnounceBean;
    DBFunctions dbFunctions;

    public TenantAnnounceFacade(TenantAnnounceBean bean, DBFunctions dbf) {
        this.tenantAnnounceBean=bean;
        this.dbFunctions=dbf;
    }

    public void
    insertTenantAnnounce() {
        boolean permission;
        RulesInterface myRulesInterface= new Rules();
        Main notify=new Main();

        TenantAnnounce myTenantAnnounce = new TenantAnnounce(
                tenantAnnounceBean.getTitle(), tenantAnnounceBean.getName(), tenantAnnounceBean.getCity(),
                tenantAnnounceBean.getRoom(), tenantAnnounceBean.getPeople(), tenantAnnounceBean.getBath(),
                tenantAnnounceBean.getDateArr(), tenantAnnounceBean.getDateDep(), tenantAnnounceBean.getWifi(),
                tenantAnnounceBean.getGarden(), tenantAnnounceBean.getAnimals(), tenantAnnounceBean.getAirConditioning(), tenantAnnounceBean.getParking());
        permission=myRulesInterface.booleanCheckAnnounce(myTenantAnnounce);

        if (permission){
            dbFunctions.insertNewTenantAnnounce(myTenantAnnounce);
            notify.notification(1,"CONFERMA","Il sottosistema rules ha accettato il tuo annuncio");
        }
        else{
            notify.notification(0,"ERRORE","Il sottosistema rules non ha accettato il tuo annuncio");
        }

    }

}