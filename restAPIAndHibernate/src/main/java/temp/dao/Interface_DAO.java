package temp.dao;

import java.util.List;

public interface Interface_DAO<G> {
    public Boolean insertG(G g);
    public Boolean deleteG(G g);
    public Boolean updateG(G g);
    public G selectG(G g);
    public List<G> selectAll();
}
