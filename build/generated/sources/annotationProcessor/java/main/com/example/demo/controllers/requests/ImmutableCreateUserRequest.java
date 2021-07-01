package com.example.demo.controllers.requests;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link CreateUserRequest}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableCreateUserRequest.builder()}.
 */
@Generated(from = "CreateUserRequest", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableCreateUserRequest
    implements CreateUserRequest {
  private final String name;
  private final String email;

  private ImmutableCreateUserRequest(String name, String email) {
    this.name = name;
    this.email = email;
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * @return The value of the {@code email} attribute
   */
  @Override
  public String getEmail() {
    return email;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CreateUserRequest#getName() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCreateUserRequest withName(String value) {
    String newValue = Objects.requireNonNull(value, "name");
    if (this.name.equals(newValue)) return this;
    return new ImmutableCreateUserRequest(newValue, this.email);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link CreateUserRequest#getEmail() email} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for email
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableCreateUserRequest withEmail(String value) {
    String newValue = Objects.requireNonNull(value, "email");
    if (this.email.equals(newValue)) return this;
    return new ImmutableCreateUserRequest(this.name, newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableCreateUserRequest} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableCreateUserRequest
        && equalTo((ImmutableCreateUserRequest) another);
  }

  private boolean equalTo(ImmutableCreateUserRequest another) {
    return name.equals(another.name)
        && email.equals(another.email);
  }

  /**
   * Computes a hash code from attributes: {@code name}, {@code email}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + name.hashCode();
    h += (h << 5) + email.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code CreateUserRequest} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "CreateUserRequest{"
        + "name=" + name
        + ", email=" + email
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link CreateUserRequest} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable CreateUserRequest instance
   */
  public static ImmutableCreateUserRequest copyOf(CreateUserRequest instance) {
    if (instance instanceof ImmutableCreateUserRequest) {
      return (ImmutableCreateUserRequest) instance;
    }
    return ImmutableCreateUserRequest.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableCreateUserRequest ImmutableCreateUserRequest}.
   * <pre>
   * ImmutableCreateUserRequest.builder()
   *    .name(String) // required {@link CreateUserRequest#getName() name}
   *    .email(String) // required {@link CreateUserRequest#getEmail() email}
   *    .build();
   * </pre>
   * @return A new ImmutableCreateUserRequest builder
   */
  public static ImmutableCreateUserRequest.Builder builder() {
    return new ImmutableCreateUserRequest.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableCreateUserRequest ImmutableCreateUserRequest}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "CreateUserRequest", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private static final long INIT_BIT_EMAIL = 0x2L;
    private long initBits = 0x3L;

    private String name;
    private String email;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code CreateUserRequest} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(CreateUserRequest instance) {
      Objects.requireNonNull(instance, "instance");
      name(instance.getName());
      email(instance.getEmail());
      return this;
    }

    /**
     * Initializes the value for the {@link CreateUserRequest#getName() name} attribute.
     * @param name The value for name 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder name(String name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link CreateUserRequest#getEmail() email} attribute.
     * @param email The value for email 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder email(String email) {
      this.email = Objects.requireNonNull(email, "email");
      initBits &= ~INIT_BIT_EMAIL;
      return this;
    }

    /**
     * Builds a new {@link ImmutableCreateUserRequest ImmutableCreateUserRequest}.
     * @return An immutable instance of CreateUserRequest
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableCreateUserRequest build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableCreateUserRequest(name, email);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_EMAIL) != 0) attributes.add("email");
      return "Cannot build CreateUserRequest, some of required attributes are not set " + attributes;
    }
  }
}
