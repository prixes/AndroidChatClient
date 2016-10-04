// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: comProtobuf.proto

package com.prixeSoft.easymessages;

public final class ComProtobuf {
  private ComProtobuf() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface msgOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.prixeSoft.easymessages.msg)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>optional string from = 1;</code>
     */
    java.lang.String getFrom();
    /**
     * <code>optional string from = 1;</code>
     */
    com.google.protobuf.ByteString
        getFromBytes();

    /**
     * <code>optional string message = 2;</code>
     */
    java.lang.String getMessage();
    /**
     * <code>optional string message = 2;</code>
     */
    com.google.protobuf.ByteString
        getMessageBytes();

    /**
     * <code>optional string to = 3;</code>
     */
    java.lang.String getTo();
    /**
     * <code>optional string to = 3;</code>
     */
    com.google.protobuf.ByteString
        getToBytes();

    /**
     * <code>optional .com.prixeSoft.easymessages.msg.msgCode type = 4;</code>
     */
    int getTypeValue();
    /**
     * <code>optional .com.prixeSoft.easymessages.msg.msgCode type = 4;</code>
     */
    com.prixeSoft.easymessages.ComProtobuf.msg.msgCode getType();
  }
  /**
   * <pre>
   * [START messages]
   * </pre>
   *
   * Protobuf type {@code com.prixeSoft.easymessages.msg}
   */
  public  static final class msg extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:com.prixeSoft.easymessages.msg)
      msgOrBuilder {
    // Use msg.newBuilder() to construct.
    private msg(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private msg() {
      from_ = "";
      message_ = "";
      to_ = "";
      type_ = 0;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private msg(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              from_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              message_ = s;
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              to_ = s;
              break;
            }
            case 32: {
              int rawValue = input.readEnum();

              type_ = rawValue;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.prixeSoft.easymessages.ComProtobuf.internal_static_com_prixeSoft_easymessages_msg_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.prixeSoft.easymessages.ComProtobuf.internal_static_com_prixeSoft_easymessages_msg_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.prixeSoft.easymessages.ComProtobuf.msg.class, com.prixeSoft.easymessages.ComProtobuf.msg.Builder.class);
    }

    /**
     * Protobuf enum {@code com.prixeSoft.easymessages.msg.msgCode}
     */
    public enum msgCode
        implements com.google.protobuf.ProtocolMessageEnum {
      /**
       * <code>ONLINEUSERS = 0;</code>
       */
      ONLINEUSERS(0),
      /**
       * <code>MESSAGE = 1;</code>
       */
      MESSAGE(1),
      /**
       * <code>LOGOUT = 2;</code>
       */
      LOGOUT(2),
      /**
       * <code>WHOAMI = 3;</code>
       */
      WHOAMI(3),
      /**
       * <code>PM = 4;</code>
       */
      PM(4),
      UNRECOGNIZED(-1),
      ;

      /**
       * <code>ONLINEUSERS = 0;</code>
       */
      public static final int ONLINEUSERS_VALUE = 0;
      /**
       * <code>MESSAGE = 1;</code>
       */
      public static final int MESSAGE_VALUE = 1;
      /**
       * <code>LOGOUT = 2;</code>
       */
      public static final int LOGOUT_VALUE = 2;
      /**
       * <code>WHOAMI = 3;</code>
       */
      public static final int WHOAMI_VALUE = 3;
      /**
       * <code>PM = 4;</code>
       */
      public static final int PM_VALUE = 4;


      public final int getNumber() {
        if (this == UNRECOGNIZED) {
          throw new java.lang.IllegalArgumentException(
              "Can't get the number of an unknown enum value.");
        }
        return value;
      }

      /**
       * @deprecated Use {@link #forNumber(int)} instead.
       */
      @java.lang.Deprecated
      public static msgCode valueOf(int value) {
        return forNumber(value);
      }

      public static msgCode forNumber(int value) {
        switch (value) {
          case 0: return ONLINEUSERS;
          case 1: return MESSAGE;
          case 2: return LOGOUT;
          case 3: return WHOAMI;
          case 4: return PM;
          default: return null;
        }
      }

      public static com.google.protobuf.Internal.EnumLiteMap<msgCode>
          internalGetValueMap() {
        return internalValueMap;
      }
      private static final com.google.protobuf.Internal.EnumLiteMap<
          msgCode> internalValueMap =
            new com.google.protobuf.Internal.EnumLiteMap<msgCode>() {
              public msgCode findValueByNumber(int number) {
                return msgCode.forNumber(number);
              }
            };

      public final com.google.protobuf.Descriptors.EnumValueDescriptor
          getValueDescriptor() {
        return getDescriptor().getValues().get(ordinal());
      }
      public final com.google.protobuf.Descriptors.EnumDescriptor
          getDescriptorForType() {
        return getDescriptor();
      }
      public static final com.google.protobuf.Descriptors.EnumDescriptor
          getDescriptor() {
        return com.prixeSoft.easymessages.ComProtobuf.msg.getDescriptor().getEnumTypes().get(0);
      }

      private static final msgCode[] VALUES = values();

      public static msgCode valueOf(
          com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
        if (desc.getType() != getDescriptor()) {
          throw new java.lang.IllegalArgumentException(
            "EnumValueDescriptor is not for this type.");
        }
        if (desc.getIndex() == -1) {
          return UNRECOGNIZED;
        }
        return VALUES[desc.getIndex()];
      }

      private final int value;

      private msgCode(int value) {
        this.value = value;
      }

      // @@protoc_insertion_point(enum_scope:com.prixeSoft.easymessages.msg.msgCode)
    }

    public static final int FROM_FIELD_NUMBER = 1;
    private volatile java.lang.Object from_;
    /**
     * <code>optional string from = 1;</code>
     */
    public java.lang.String getFrom() {
      java.lang.Object ref = from_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        from_ = s;
        return s;
      }
    }
    /**
     * <code>optional string from = 1;</code>
     */
    public com.google.protobuf.ByteString
        getFromBytes() {
      java.lang.Object ref = from_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        from_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int MESSAGE_FIELD_NUMBER = 2;
    private volatile java.lang.Object message_;
    /**
     * <code>optional string message = 2;</code>
     */
    public java.lang.String getMessage() {
      java.lang.Object ref = message_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        message_ = s;
        return s;
      }
    }
    /**
     * <code>optional string message = 2;</code>
     */
    public com.google.protobuf.ByteString
        getMessageBytes() {
      java.lang.Object ref = message_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        message_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TO_FIELD_NUMBER = 3;
    private volatile java.lang.Object to_;
    /**
     * <code>optional string to = 3;</code>
     */
    public java.lang.String getTo() {
      java.lang.Object ref = to_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        to_ = s;
        return s;
      }
    }
    /**
     * <code>optional string to = 3;</code>
     */
    public com.google.protobuf.ByteString
        getToBytes() {
      java.lang.Object ref = to_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        to_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int TYPE_FIELD_NUMBER = 4;
    private int type_;
    /**
     * <code>optional .com.prixeSoft.easymessages.msg.msgCode type = 4;</code>
     */
    public int getTypeValue() {
      return type_;
    }
    /**
     * <code>optional .com.prixeSoft.easymessages.msg.msgCode type = 4;</code>
     */
    public com.prixeSoft.easymessages.ComProtobuf.msg.msgCode getType() {
      com.prixeSoft.easymessages.ComProtobuf.msg.msgCode result = com.prixeSoft.easymessages.ComProtobuf.msg.msgCode.valueOf(type_);
      return result == null ? com.prixeSoft.easymessages.ComProtobuf.msg.msgCode.UNRECOGNIZED : result;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getFromBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, from_);
      }
      if (!getMessageBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, message_);
      }
      if (!getToBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, to_);
      }
      if (type_ != com.prixeSoft.easymessages.ComProtobuf.msg.msgCode.ONLINEUSERS.getNumber()) {
        output.writeEnum(4, type_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getFromBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, from_);
      }
      if (!getMessageBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, message_);
      }
      if (!getToBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, to_);
      }
      if (type_ != com.prixeSoft.easymessages.ComProtobuf.msg.msgCode.ONLINEUSERS.getNumber()) {
        size += com.google.protobuf.CodedOutputStream
          .computeEnumSize(4, type_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof com.prixeSoft.easymessages.ComProtobuf.msg)) {
        return super.equals(obj);
      }
      com.prixeSoft.easymessages.ComProtobuf.msg other = (com.prixeSoft.easymessages.ComProtobuf.msg) obj;

      boolean result = true;
      result = result && getFrom()
          .equals(other.getFrom());
      result = result && getMessage()
          .equals(other.getMessage());
      result = result && getTo()
          .equals(other.getTo());
      result = result && type_ == other.type_;
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptorForType().hashCode();
      hash = (37 * hash) + FROM_FIELD_NUMBER;
      hash = (53 * hash) + getFrom().hashCode();
      hash = (37 * hash) + MESSAGE_FIELD_NUMBER;
      hash = (53 * hash) + getMessage().hashCode();
      hash = (37 * hash) + TO_FIELD_NUMBER;
      hash = (53 * hash) + getTo().hashCode();
      hash = (37 * hash) + TYPE_FIELD_NUMBER;
      hash = (53 * hash) + type_;
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static com.prixeSoft.easymessages.ComProtobuf.msg parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.prixeSoft.easymessages.ComProtobuf.msg parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.prixeSoft.easymessages.ComProtobuf.msg parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.prixeSoft.easymessages.ComProtobuf.msg parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.prixeSoft.easymessages.ComProtobuf.msg parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.prixeSoft.easymessages.ComProtobuf.msg parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.prixeSoft.easymessages.ComProtobuf.msg parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static com.prixeSoft.easymessages.ComProtobuf.msg parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static com.prixeSoft.easymessages.ComProtobuf.msg parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static com.prixeSoft.easymessages.ComProtobuf.msg parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(com.prixeSoft.easymessages.ComProtobuf.msg prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * <pre>
     * [START messages]
     * </pre>
     *
     * Protobuf type {@code com.prixeSoft.easymessages.msg}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.prixeSoft.easymessages.msg)
        com.prixeSoft.easymessages.ComProtobuf.msgOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.prixeSoft.easymessages.ComProtobuf.internal_static_com_prixeSoft_easymessages_msg_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.prixeSoft.easymessages.ComProtobuf.internal_static_com_prixeSoft_easymessages_msg_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.prixeSoft.easymessages.ComProtobuf.msg.class, com.prixeSoft.easymessages.ComProtobuf.msg.Builder.class);
      }

      // Construct using com.prixeSoft.easymessages.ComProtobuf.msg.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        from_ = "";

        message_ = "";

        to_ = "";

        type_ = 0;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.prixeSoft.easymessages.ComProtobuf.internal_static_com_prixeSoft_easymessages_msg_descriptor;
      }

      public com.prixeSoft.easymessages.ComProtobuf.msg getDefaultInstanceForType() {
        return com.prixeSoft.easymessages.ComProtobuf.msg.getDefaultInstance();
      }

      public com.prixeSoft.easymessages.ComProtobuf.msg build() {
        com.prixeSoft.easymessages.ComProtobuf.msg result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.prixeSoft.easymessages.ComProtobuf.msg buildPartial() {
        com.prixeSoft.easymessages.ComProtobuf.msg result = new com.prixeSoft.easymessages.ComProtobuf.msg(this);
        result.from_ = from_;
        result.message_ = message_;
        result.to_ = to_;
        result.type_ = type_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.prixeSoft.easymessages.ComProtobuf.msg) {
          return mergeFrom((com.prixeSoft.easymessages.ComProtobuf.msg)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.prixeSoft.easymessages.ComProtobuf.msg other) {
        if (other == com.prixeSoft.easymessages.ComProtobuf.msg.getDefaultInstance()) return this;
        if (!other.getFrom().isEmpty()) {
          from_ = other.from_;
          onChanged();
        }
        if (!other.getMessage().isEmpty()) {
          message_ = other.message_;
          onChanged();
        }
        if (!other.getTo().isEmpty()) {
          to_ = other.to_;
          onChanged();
        }
        if (other.type_ != 0) {
          setTypeValue(other.getTypeValue());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.prixeSoft.easymessages.ComProtobuf.msg parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.prixeSoft.easymessages.ComProtobuf.msg) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object from_ = "";
      /**
       * <code>optional string from = 1;</code>
       */
      public java.lang.String getFrom() {
        java.lang.Object ref = from_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          from_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string from = 1;</code>
       */
      public com.google.protobuf.ByteString
          getFromBytes() {
        java.lang.Object ref = from_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          from_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string from = 1;</code>
       */
      public Builder setFrom(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        from_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string from = 1;</code>
       */
      public Builder clearFrom() {
        
        from_ = getDefaultInstance().getFrom();
        onChanged();
        return this;
      }
      /**
       * <code>optional string from = 1;</code>
       */
      public Builder setFromBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        from_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object message_ = "";
      /**
       * <code>optional string message = 2;</code>
       */
      public java.lang.String getMessage() {
        java.lang.Object ref = message_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          message_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string message = 2;</code>
       */
      public com.google.protobuf.ByteString
          getMessageBytes() {
        java.lang.Object ref = message_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          message_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string message = 2;</code>
       */
      public Builder setMessage(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        message_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string message = 2;</code>
       */
      public Builder clearMessage() {
        
        message_ = getDefaultInstance().getMessage();
        onChanged();
        return this;
      }
      /**
       * <code>optional string message = 2;</code>
       */
      public Builder setMessageBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        message_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object to_ = "";
      /**
       * <code>optional string to = 3;</code>
       */
      public java.lang.String getTo() {
        java.lang.Object ref = to_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          to_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>optional string to = 3;</code>
       */
      public com.google.protobuf.ByteString
          getToBytes() {
        java.lang.Object ref = to_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          to_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>optional string to = 3;</code>
       */
      public Builder setTo(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        to_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional string to = 3;</code>
       */
      public Builder clearTo() {
        
        to_ = getDefaultInstance().getTo();
        onChanged();
        return this;
      }
      /**
       * <code>optional string to = 3;</code>
       */
      public Builder setToBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        to_ = value;
        onChanged();
        return this;
      }

      private int type_ = 0;
      /**
       * <code>optional .com.prixeSoft.easymessages.msg.msgCode type = 4;</code>
       */
      public int getTypeValue() {
        return type_;
      }
      /**
       * <code>optional .com.prixeSoft.easymessages.msg.msgCode type = 4;</code>
       */
      public Builder setTypeValue(int value) {
        type_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional .com.prixeSoft.easymessages.msg.msgCode type = 4;</code>
       */
      public com.prixeSoft.easymessages.ComProtobuf.msg.msgCode getType() {
        com.prixeSoft.easymessages.ComProtobuf.msg.msgCode result = com.prixeSoft.easymessages.ComProtobuf.msg.msgCode.valueOf(type_);
        return result == null ? com.prixeSoft.easymessages.ComProtobuf.msg.msgCode.UNRECOGNIZED : result;
      }
      /**
       * <code>optional .com.prixeSoft.easymessages.msg.msgCode type = 4;</code>
       */
      public Builder setType(com.prixeSoft.easymessages.ComProtobuf.msg.msgCode value) {
        if (value == null) {
          throw new NullPointerException();
        }
        
        type_ = value.getNumber();
        onChanged();
        return this;
      }
      /**
       * <code>optional .com.prixeSoft.easymessages.msg.msgCode type = 4;</code>
       */
      public Builder clearType() {
        
        type_ = 0;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:com.prixeSoft.easymessages.msg)
    }

    // @@protoc_insertion_point(class_scope:com.prixeSoft.easymessages.msg)
    private static final com.prixeSoft.easymessages.ComProtobuf.msg DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new com.prixeSoft.easymessages.ComProtobuf.msg();
    }

    public static com.prixeSoft.easymessages.ComProtobuf.msg getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<msg>
        PARSER = new com.google.protobuf.AbstractParser<msg>() {
      public msg parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new msg(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<msg> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<msg> getParserForType() {
      return PARSER;
    }

    public com.prixeSoft.easymessages.ComProtobuf.msg getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_prixeSoft_easymessages_msg_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_com_prixeSoft_easymessages_msg_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\021comProtobuf.proto\022\032com.prixeSoft.easym" +
      "essages\"\260\001\n\003msg\022\014\n\004from\030\001 \001(\t\022\017\n\007message" +
      "\030\002 \001(\t\022\n\n\002to\030\003 \001(\t\0225\n\004type\030\004 \001(\0162\'.com.p" +
      "rixeSoft.easymessages.msg.msgCode\"G\n\007msg" +
      "Code\022\017\n\013ONLINEUSERS\020\000\022\013\n\007MESSAGE\020\001\022\n\n\006LO" +
      "GOUT\020\002\022\n\n\006WHOAMI\020\003\022\006\n\002PM\020\004B)\n\032com.prixeS" +
      "oft.easymessagesB\013ComProtobufb\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_prixeSoft_easymessages_msg_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_prixeSoft_easymessages_msg_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_com_prixeSoft_easymessages_msg_descriptor,
        new java.lang.String[] { "From", "Message", "To", "Type", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
