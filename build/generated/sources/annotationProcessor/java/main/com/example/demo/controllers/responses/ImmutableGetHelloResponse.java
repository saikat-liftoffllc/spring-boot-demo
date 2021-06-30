package com.example.demo.controllers.responses;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.immutables.value.Generated;

/**
 * Immutable implementation of {@link GetHelloResponse}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableGetHelloResponse.builder()}.
 */
@Generated(from = "GetHelloResponse", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class ImmutableGetHelloResponse
    implements GetHelloResponse {
  private final String message;

  private ImmutableGetHelloResponse(String message) {
    this.message = message;
  }

  /**
   * @return The value of the {@code message} attribute
   */
  @Override
  public String getMessage() {
    return message;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link GetHelloResponse#getMessage() message} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for message
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableGetHelloResponse withMessage(String value) {
    String newValue = Objects.requireNonNull(value, "message");
    if (this.message.equals(newValue)) return this;
    return new ImmutableGetHelloResponse(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableGetHelloResponse} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableGetHelloResponse
        && equalTo((ImmutableGetHelloResponse) another);
  }

  private boolean equalTo(ImmutableGetHelloResponse another) {
    return message.equals(another.message);
  }

  /**
   * Computes a hash code from attributes: {@code message}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + message.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code GetHelloResponse} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "GetHelloResponse{"
        + "message=" + message
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link GetHelloResponse} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable GetHelloResponse instance
   */
  public static ImmutableGetHelloResponse copyOf(GetHelloResponse instance) {
    if (instance instanceof ImmutableGetHelloResponse) {
      return (ImmutableGetHelloResponse) instance;
    }
    return ImmutableGetHelloResponse.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableGetHelloResponse ImmutableGetHelloResponse}.
   * <pre>
   * ImmutableGetHelloResponse.builder()
   *    .message(String) // required {@link GetHelloResponse#getMessage() message}
   *    .build();
   * </pre>
   * @return A new ImmutableGetHelloResponse builder
   */
  public static ImmutableGetHelloResponse.Builder builder() {
    return new ImmutableGetHelloResponse.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableGetHelloResponse ImmutableGetHelloResponse}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "GetHelloResponse", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_MESSAGE = 0x1L;
    private long initBits = 0x1L;

    private String message;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code GetHelloResponse} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(GetHelloResponse instance) {
      Objects.requireNonNull(instance, "instance");
      message(instance.getMessage());
      return this;
    }

    /**
     * Initializes the value for the {@link GetHelloResponse#getMessage() message} attribute.
     * @param message The value for message 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder message(String message) {
      this.message = Objects.requireNonNull(message, "message");
      initBits &= ~INIT_BIT_MESSAGE;
      return this;
    }

    /**
     * Builds a new {@link ImmutableGetHelloResponse ImmutableGetHelloResponse}.
     * @return An immutable instance of GetHelloResponse
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableGetHelloResponse build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableGetHelloResponse(message);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_MESSAGE) != 0) attributes.add("message");
      return "Cannot build GetHelloResponse, some of required attributes are not set " + attributes;
    }
  }
}
