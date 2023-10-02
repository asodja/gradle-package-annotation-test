package com.github.asodja.test.annotations;

import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierDefault;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.PACKAGE})
@org.jetbrains.annotations.NotNull
@Nonnull
@TypeQualifierDefault({ElementType.METHOD, ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface NonNullApi {
}
