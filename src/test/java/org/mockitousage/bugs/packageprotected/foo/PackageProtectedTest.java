package org.mockitousage.bugs.packageprotected.foo;

import org.junit.Test;
import org.mockitousage.bugs.packageprotected.bar.ChildClassInAnotherPackage;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

/**
 * In issue 1196, user reported that package protected classes in a matcher no longer work.
 * This test throws a IllegalArgumentException, as the real method is called anyways.
 */
public class PackageProtectedTest {

    static class PackageProtectedType {
    }

    public static class ParentClass {
        protected String call(PackageProtectedType arg) {
            throw new IllegalArgumentException("This real method should not be called");
        }
    }

    @Test
    public void failWithNPEWhenCallingRealMethod() {
        ParentClass underTest = spy(new ChildClassInAnotherPackage());
        doReturn(null).when(underTest).call(any(PackageProtectedType.class));
    }
}
