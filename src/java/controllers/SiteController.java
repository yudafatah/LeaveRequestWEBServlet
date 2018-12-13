package controllers;

import daos.GeneralDAO;
import interfaces.DAOInterface;
import java.util.List;
import org.hibernate.SessionFactory;


/**
 *
 * @author Andi SR
 */
public class SiteController implements interfaces.Siteinterface {

    DAOInterface daoi;

    public SiteController() {
    }

    public SiteController(SessionFactory factory) {
        this.daoi = new GeneralDAO(factory);
    }
    
    /**
     * Get All dari entities Site
     * @param entity
     * @param keyword
     * @return 
     */
    @Override
    public List<Object> getAllSite(Object entity, String keyword, Object id) {
        return this.daoi.doDDL(new entities.Site(), keyword, id);
    }

    @Override
    public List<Object> getAllDataObj(Object entity) {
        return this.daoi.getAllDataObj(entity, "");
    }

}
