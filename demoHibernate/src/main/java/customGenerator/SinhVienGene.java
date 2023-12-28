package customGenerator;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class SinhVienGene implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        try {
            String customId = "SV " + java.util.Calendar.getInstance().getTime();
            return customId;
        } catch (Exception e) {
            throw new HibernateException("Failed to generate custom ID: " + e.getMessage(), e);
        }
    }
}
