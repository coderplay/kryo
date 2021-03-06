
package com.esotericsoftware.kryo.serializers;

import java.lang.reflect.Array;
import java.lang.reflect.Modifier;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import static com.esotericsoftware.kryo.Kryo.*;

/** Contains many serializer classes for specific array types that are provided by {@link Kryo#addDefaultSerializer(Class, Class)
 * default}.
 * @author Nathan Sweet <misc@n4te.com> */
public class DefaultArraySerializers {
	static public class ByteArraySerializer extends Serializer<byte[]> {
		{
			setAcceptsNull(true);
		}

		public void write (Kryo kryo, Output output, byte[] object) {
			if (object == null) {
				output.writeByte(NULL);
				return;
			}
			output.writeInt(object.length + 1, true);
			output.writeBytes(object);
		}

		public byte[] create (Kryo kryo, Input input, Class<byte[]> type) {
			int length = input.readInt(true);
			if (length == NULL) return null;
			return input.readBytes(length - 1);
		}

		public byte[] createCopy (Kryo kryo, byte[] original) {
			byte[] copy = new byte[original.length];
			System.arraycopy(original, 0, copy, 0, copy.length);
			return copy;
		}
	}

	static public class IntArraySerializer extends Serializer<int[]> {
		{
			setAcceptsNull(true);
		}

		public void write (Kryo kryo, Output output, int[] object) {
			if (object == null) {
				output.writeByte(NULL);
				return;
			}
			output.writeInt(object.length + 1, true);
			for (int i = 0, n = object.length; i < n; i++)
				output.writeInt(object[i], false);
		}

		public int[] create (Kryo kryo, Input input, Class<int[]> type) {
			int length = input.readInt(true);
			if (length == NULL) return null;
			int[] array = new int[--length];
			for (int i = 0; i < length; i++)
				array[i] = input.readInt(false);
			return array;
		}

		public int[] createCopy (Kryo kryo, int[] original) {
			int[] copy = new int[original.length];
			System.arraycopy(original, 0, copy, 0, copy.length);
			return copy;
		}
	}

	static public class FloatArraySerializer extends Serializer<float[]> {
		{
			setAcceptsNull(true);
		}

		public void write (Kryo kryo, Output output, float[] object) {
			if (object == null) {
				output.writeByte(NULL);
				return;
			}
			output.writeInt(object.length + 1, true);
			for (int i = 0, n = object.length; i < n; i++)
				output.writeFloat(object[i]);
		}

		public float[] create (Kryo kryo, Input input, Class<float[]> type) {
			int length = input.readInt(true);
			if (length == NULL) return null;
			float[] array = new float[--length];
			for (int i = 0; i < length; i++)
				array[i] = input.readFloat();
			return array;
		}

		public float[] createCopy (Kryo kryo, float[] original) {
			float[] copy = new float[original.length];
			System.arraycopy(original, 0, copy, 0, copy.length);
			return copy;
		}
	}

	static public class LongArraySerializer extends Serializer<long[]> {
		{
			setAcceptsNull(true);
		}

		public void write (Kryo kryo, Output output, long[] object) {
			if (object == null) {
				output.writeByte(NULL);
				return;
			}
			output.writeInt(object.length + 1, true);
			for (int i = 0, n = object.length; i < n; i++)
				output.writeLong(object[i], false);
		}

		public long[] create (Kryo kryo, Input input, Class<long[]> type) {
			int length = input.readInt(true);
			if (length == NULL) return null;
			long[] array = new long[--length];
			for (int i = 0; i < length; i++)
				array[i] = input.readLong(false);
			return array;
		}

		public long[] createCopy (Kryo kryo, long[] original) {
			long[] copy = new long[original.length];
			System.arraycopy(original, 0, copy, 0, copy.length);
			return copy;
		}
	}

	static public class ShortArraySerializer extends Serializer<short[]> {
		{
			setAcceptsNull(true);
		}

		public void write (Kryo kryo, Output output, short[] object) {
			if (object == null) {
				output.writeByte(NULL);
				return;
			}
			output.writeInt(object.length + 1, true);
			for (int i = 0, n = object.length; i < n; i++)
				output.writeShort(object[i]);
		}

		public short[] create (Kryo kryo, Input input, Class<short[]> type) {
			int length = input.readInt(true);
			if (length == NULL) return null;
			short[] array = new short[--length];
			for (int i = 0; i < length; i++)
				array[i] = input.readShort();
			return array;
		}

		public short[] createCopy (Kryo kryo, short[] original) {
			short[] copy = new short[original.length];
			System.arraycopy(original, 0, copy, 0, copy.length);
			return copy;
		}
	}

	static public class CharArraySerializer extends Serializer<char[]> {
		{
			setAcceptsNull(true);
		}

		public void write (Kryo kryo, Output output, char[] object) {
			if (object == null) {
				output.writeByte(NULL);
				return;
			}
			output.writeInt(object.length + 1, true);
			for (int i = 0, n = object.length; i < n; i++)
				output.writeChar(object[i]);
		}

		public char[] create (Kryo kryo, Input input, Class<char[]> type) {
			int length = input.readInt(true);
			if (length == NULL) return null;
			char[] array = new char[--length];
			for (int i = 0; i < length; i++)
				array[i] = input.readChar();
			return array;
		}

		public char[] createCopy (Kryo kryo, char[] original) {
			char[] copy = new char[original.length];
			System.arraycopy(original, 0, copy, 0, copy.length);
			return copy;
		}
	}

	static public class DoubleArraySerializer extends Serializer<double[]> {
		{
			setAcceptsNull(true);
		}

		public void write (Kryo kryo, Output output, double[] object) {
			if (object == null) {
				output.writeByte(NULL);
				return;
			}
			output.writeInt(object.length + 1, true);
			for (int i = 0, n = object.length; i < n; i++)
				output.writeDouble(object[i]);
		}

		public double[] create (Kryo kryo, Input input, Class<double[]> type) {
			int length = input.readInt(true);
			if (length == NULL) return null;
			double[] array = new double[--length];
			for (int i = 0; i < length; i++)
				array[i] = input.readDouble();
			return array;
		}

		public double[] createCopy (Kryo kryo, double[] original) {
			double[] copy = new double[original.length];
			System.arraycopy(original, 0, copy, 0, copy.length);
			return copy;
		}
	}

	static public class BooleanArraySerializer extends Serializer<boolean[]> {
		{
			setAcceptsNull(true);
		}

		public void write (Kryo kryo, Output output, boolean[] object) {
			if (object == null) {
				output.writeByte(NULL);
				return;
			}
			output.writeInt(object.length + 1, true);
			for (int i = 0, n = object.length; i < n; i++)
				output.writeBoolean(object[i]);
		}

		public boolean[] create (Kryo kryo, Input input, Class<boolean[]> type) {
			int length = input.readInt(true);
			if (length == NULL) return null;
			boolean[] array = new boolean[--length];
			for (int i = 0; i < length; i++)
				array[i] = input.readBoolean();
			return array;
		}

		public boolean[] createCopy (Kryo kryo, boolean[] original) {
			boolean[] copy = new boolean[original.length];
			System.arraycopy(original, 0, copy, 0, copy.length);
			return copy;
		}
	}

	static public class StringArraySerializer extends Serializer<String[]> {
		{
			setAcceptsNull(true);
		}

		public void write (Kryo kryo, Output output, String[] object) {
			if (object == null) {
				output.writeByte(NULL);
				return;
			}
			output.writeInt(object.length + 1, true);
			for (int i = 0, n = object.length; i < n; i++)
				output.writeString(object[i]);
		}

		public String[] create (Kryo kryo, Input input, Class<String[]> type) {
			int length = input.readInt(true);
			if (length == NULL) return null;
			String[] array = new String[--length];
			for (int i = 0; i < length; i++)
				array[i] = input.readString();
			return array;
		}

		public String[] createCopy (Kryo kryo, String[] original) {
			String[] copy = new String[original.length];
			System.arraycopy(original, 0, copy, 0, copy.length);
			return copy;
		}
	}

	static public class ObjectArraySerializer extends Serializer<Object[]> {
		private boolean elementsAreSameType;
		private boolean elementsCanBeNull = true;

		{
			setAcceptsNull(true);
		}

		public void write (Kryo kryo, Output output, Object[] object) {
			if (object == null) {
				output.writeByte(NULL);
				return;
			}
			output.writeInt(object.length + 1, true);
			Class elementClass = object.getClass().getComponentType();
			if (elementsAreSameType || Modifier.isFinal(elementClass.getModifiers())) {
				Serializer elementSerializer = kryo.getSerializer(elementClass);
				for (int i = 0, n = object.length; i < n; i++) {
					if (elementsCanBeNull)
						kryo.writeObjectOrNull(output, object[i], elementSerializer);
					else
						kryo.writeObject(output, object[i], elementSerializer);
				}
			} else {
				for (int i = 0, n = object.length; i < n; i++)
					kryo.writeClassAndObject(output, object[i]);
			}
		}

		public Object[] create (Kryo kryo, Input input, Class<Object[]> type) {
			int length = input.readInt(true);
			if (length == NULL) return null;
			return (Object[])Array.newInstance(type.getComponentType(), length - 1);
		}

		public void read (Kryo kryo, Input input, Object[] object) {
			Class elementClass = object.getClass().getComponentType();
			if (elementsAreSameType || Modifier.isFinal(elementClass.getModifiers())) {
				Serializer elementSerializer = kryo.getSerializer(elementClass);
				for (int i = 0, n = object.length; i < n; i++) {
					if (elementsCanBeNull)
						object[i] = kryo.readObjectOrNull(input, elementClass, elementSerializer);
					else
						object[i] = kryo.readObject(input, elementClass, elementSerializer);
				}
			} else {
				for (int i = 0, n = object.length; i < n; i++)
					object[i] = kryo.readClassAndObject(input);
			}
		}

		public Object[] createCopy (Kryo kryo, Object[] original) {
			Object[] copy = new Object[original.length];
			System.arraycopy(original, 0, copy, 0, copy.length);
			return copy;
		}

		/** @param elementsCanBeNull False if all elements are not null. This saves 1 byte per element if the array type is final or
		 *           elementsAreSameClassAsType is true. True if it is not known (default). */
		public void setElementsCanBeNull (boolean elementsCanBeNull) {
			this.elementsCanBeNull = elementsCanBeNull;
		}

		/** @param elementsAreSameType True if all elements are the same type as the array (ie they don't extend the array type). This
		 *           saves 1 byte per element if the array type is not final. Set to false if the array type is final or elements
		 *           extend the array type (default). */
		public void setElementsAreSameType (boolean elementsAreSameType) {
			this.elementsAreSameType = elementsAreSameType;
		}
	}
}
