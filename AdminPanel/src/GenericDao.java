import java.io.Serializable;
import java.sql.SQLException;

public interface GenericDao<T, PK extends Serializable> {

	public T create(T object) throws SQLException;

	public T readById(long key) throws SQLException;

	public void update(T object) throws SQLException;

	public void delete(T object) throws SQLException;

}
