package se.ericthelin.bootstrap;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ClassNameMessageCatalogTest {

    @Test
    public void messageIsDerivedFromClassName() {
	MessageCatalog catalog = new ClassNameMessageCatalog();

	assertThat(catalog.messageFor(NullArgumentException.class),
		is(equalTo("Null argument")));

	assertThat(catalog.messageFor(IllegalStateException.class),
		is(equalTo("Illegal state")));
    }

}
