package carsale.data;

import carsale.models.Roles;
import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RolesTest {
    private static final Db STORAGE = DbHibernate.getInstance();

    @Test
    @Ignore
    public void adARole() {
        Roles role = new Roles("test");
        boolean i = STORAGE.addNewRole(role);
        assertThat(role, is(this.STORAGE.getRoleById(role.getId())));
    }
}
