package vn.DungVipPro.demoSpringMVC.service;

public class ErrorService {
    private Integer id;
    private String status;

    public ErrorService(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public ErrorService() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
