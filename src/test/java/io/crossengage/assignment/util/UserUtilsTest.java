/**
 *
 */
package io.crossengage.assignment.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import io.crossengage.assignment.bo.User;
import io.crossengage.assignment.exception.InvalidFormatException;

/**
 * @author mustafa.kamel
 *
 */
public class UserUtilsTest {

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testFromString_active() throws InvalidFormatException {
        final String userString = "mustafa dagher, dagher.mustafa@gmail.com, true";
        final User user = UserUtils.fromString(userString);
        assertNotNull(user);
        assertEquals("mustafa dagher", user.getUsername());
        assertEquals("dagher.mustafa@gmail.com", user.getEmail());
        assertTrue(user.isActive());
    }

    @Test
    public void testFromString_inactive() throws InvalidFormatException {
        final String userString = "mustafa dagher, dagher.mustafa@gmail.com, false";
        final User user = UserUtils.fromString(userString);
        assertNotNull(user);
        assertEquals("mustafa dagher", user.getUsername());
        assertEquals("dagher.mustafa@gmail.com", user.getEmail());
        assertFalse(user.isActive());
    }

    @Test
    public void testFromString_exception()
    {
        final String userString = "mustafa dagher, dagher.mustafa@gmail.com - false";
        try {
            UserUtils.fromString(userString);
        } catch (final InvalidFormatException e) {
            assertTrue(e instanceof InvalidFormatException);
        }

    }

}
