package Interfaces;

import entity.TenantAnnounce;

public class Rules  implements RulesInterface{
    @Override
    public boolean booleanCheckAnnounce(TenantAnnounce announce) {
        return true;
    }
}
