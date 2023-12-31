package vn.DungVipPro.restAPIAndHibernate.service;


import java.util.List;

public interface Interface_Service<G> {
    public List<G> getList();
    public G getG(G g);
    public Boolean addG(G g);
    public Boolean deleteG(G g);
    public Boolean updateG(G g);
}
