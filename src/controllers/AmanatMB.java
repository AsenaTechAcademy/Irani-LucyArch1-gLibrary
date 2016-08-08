package controllers;

import common.model.Amanat;
import service.AmanatService;
import service.AmanatServiceImpl;
import service.ServiceManager;

import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;


@ManagedBean
@RequestScoped

public class AmanatMB
{
    Amanat amanat =new Amanat();
    AmanatService as=new AmanatServiceImpl();

    
    @PreDestroy
    public void CleanUp()
    {
    	ServiceManager.CleanEntityManagers();
    }

    
    
    private String bookid;
    private String memberid;


    private String errmsg="";


    public String save()
    {
        try
        {
            as.AddNewAmanat(amanat, Integer.parseInt(bookid), Integer.parseInt(memberid));
            amanat = new Amanat();
            return "Amanats";
        }
        catch (Exception ex)
        {
            //FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,ex.getMessage(), null);
            //RequestContext.getCurrentInstance().showMessageInDialog(message);
            errmsg=ex.getMessage();
            return "";
        }
    }


    public List<Amanat> GetAllAmanat()
    {
        return as.GetAllAmanat();
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

}
