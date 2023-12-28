package dao;

import java.util.List;

public interface InterfaceDAO <G> {
    public Boolean saveG(G g);
    public Boolean deleteG(G g);
    public Boolean updateG(G g);
    public List<G> selectAll();
    public G selectG(G g);
}
