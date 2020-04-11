package data;

import models.Ads;
import models.Roles;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RolesTest {
    private static final Db STORAGE = DbHibernate.getInstance();

    @Test
    @Ignore
    public void adARole() {
        Roles role = new Roles(4, "test");
        boolean i = STORAGE.addNewRole(role);
        assertThat(role, is(this.STORAGE.getRoleById(role.getId())));
    }
}