package com.tencent.mm.cache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MCacheItem implements Parcelable {
    public static final Creator<MCacheItem> CREATOR = new Creator<MCacheItem>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MCacheItem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(57827);
            MCacheItem mCacheItem = new MCacheItem(parcel);
            AppMethodBeat.o(57827);
            return mCacheItem;
        }
    };
    private c efu;

    static class a {
        public static Map<Class<?>, Method> efv = new HashMap();
        public static Map<Class<?>, Method> efw = new HashMap();

        a() {
        }

        static {
            AppMethodBeat.i(57844);
            try {
                efv.put(byte[].class, a.class.getMethod("keep_writeByteArray", new Class[]{Parcel.class, Field.class, Object.class}));
                efv.put(Short.TYPE, a.class.getMethod("keep_writeShort", new Class[]{Parcel.class, Field.class, Object.class}));
                efv.put(Short.class, a.class.getMethod("keep_writeShort", new Class[]{Parcel.class, Field.class, Object.class}));
                efv.put(Boolean.TYPE, a.class.getMethod("keep_writeBoolean", new Class[]{Parcel.class, Field.class, Object.class}));
                efv.put(Boolean.class, a.class.getMethod("keep_writeBoolean", new Class[]{Parcel.class, Field.class, Object.class}));
                efv.put(Integer.TYPE, a.class.getMethod("keep_writeInt", new Class[]{Parcel.class, Field.class, Object.class}));
                efv.put(Integer.class, a.class.getMethod("keep_writeInt", new Class[]{Parcel.class, Field.class, Object.class}));
                efv.put(Float.TYPE, a.class.getMethod("keep_writeFloat", new Class[]{Parcel.class, Field.class, Object.class}));
                efv.put(Float.class, a.class.getMethod("keep_writeFloat", new Class[]{Parcel.class, Field.class, Object.class}));
                efv.put(Double.TYPE, a.class.getMethod("keep_writeDouble", new Class[]{Parcel.class, Field.class, Object.class}));
                efv.put(Double.class, a.class.getMethod("keep_writeDouble", new Class[]{Parcel.class, Field.class, Object.class}));
                efv.put(Long.TYPE, a.class.getMethod("keep_writeLong", new Class[]{Parcel.class, Field.class, Object.class}));
                efv.put(Long.class, a.class.getMethod("keep_writeLong", new Class[]{Parcel.class, Field.class, Object.class}));
                efv.put(String.class, a.class.getMethod("keep_writeString", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(byte[].class, a.class.getMethod("keep_readByteArray", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(Short.TYPE, a.class.getMethod("keep_readShort", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(Short.class, a.class.getMethod("keep_readShort", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(Boolean.TYPE, a.class.getMethod("keep_readBoolean", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(Boolean.class, a.class.getMethod("keep_readBoolean", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(Integer.TYPE, a.class.getMethod("keep_readInt", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(Integer.class, a.class.getMethod("keep_readInt", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(Float.TYPE, a.class.getMethod("keep_readFloat", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(Float.class, a.class.getMethod("keep_readFloat", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(Double.TYPE, a.class.getMethod("keep_readDouble", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(Double.class, a.class.getMethod("keep_readDouble", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(Long.TYPE, a.class.getMethod("keep_readLong", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(Long.class, a.class.getMethod("keep_readLong", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(String.class, a.class.getMethod("keep_readString", new Class[]{Parcel.class, Field.class, Object.class}));
                AppMethodBeat.o(57844);
            } catch (Exception e) {
                ab.e("MicroMsg.MCacheItem", "exception:%s", bo.l(e));
                AppMethodBeat.o(57844);
            }
        }

        public static void keep_writeByteArray(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(57828);
            try {
                parcel.writeByteArray((byte[]) field.get(obj));
                AppMethodBeat.o(57828);
            } catch (Exception e) {
                ab.e("MicroMsg.MCacheItem", "exception:%s", bo.l(e));
                AppMethodBeat.o(57828);
            }
        }

        public static void keep_writeShort(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(57829);
            try {
                parcel.writeInt(field.getShort(obj));
                AppMethodBeat.o(57829);
            } catch (Exception e) {
                ab.e("MicroMsg.MCacheItem", "exception:%s", bo.l(e));
                AppMethodBeat.o(57829);
            }
        }

        public static void keep_writeBoolean(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(57830);
            try {
                parcel.writeInt(field.getBoolean(obj) ? 1 : 0);
                AppMethodBeat.o(57830);
            } catch (Exception e) {
                ab.e("MicroMsg.MCacheItem", "exception:%s", bo.l(e));
                AppMethodBeat.o(57830);
            }
        }

        public static void keep_writeInt(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(57831);
            try {
                parcel.writeInt(field.getInt(obj));
                AppMethodBeat.o(57831);
            } catch (Exception e) {
                ab.e("MicroMsg.MCacheItem", "exception:%s", bo.l(e));
                AppMethodBeat.o(57831);
            }
        }

        public static void keep_writeFloat(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(57832);
            try {
                parcel.writeFloat(field.getFloat(obj));
                AppMethodBeat.o(57832);
            } catch (Exception e) {
                ab.e("MicroMsg.MCacheItem", "exception:%s", bo.l(e));
                AppMethodBeat.o(57832);
            }
        }

        public static void keep_writeDouble(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(57833);
            try {
                parcel.writeDouble(field.getDouble(obj));
                AppMethodBeat.o(57833);
            } catch (Exception e) {
                ab.e("MicroMsg.MCacheItem", "exception:%s", bo.l(e));
                AppMethodBeat.o(57833);
            }
        }

        public static void keep_writeLong(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(57834);
            try {
                parcel.writeLong(field.getLong(obj));
                AppMethodBeat.o(57834);
            } catch (Exception e) {
                ab.e("MicroMsg.MCacheItem", "exception:%s", bo.l(e));
                AppMethodBeat.o(57834);
            }
        }

        public static void keep_writeString(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(57835);
            try {
                parcel.writeString((String) field.get(obj));
                AppMethodBeat.o(57835);
            } catch (Exception e) {
                ab.e("MicroMsg.MCacheItem", "exception:%s", bo.l(e));
                AppMethodBeat.o(57835);
            }
        }

        public static void keep_readByteArray(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(57836);
            try {
                field.set(obj, parcel.createByteArray());
                AppMethodBeat.o(57836);
            } catch (Exception e) {
                ab.e("MicroMsg.MCacheItem", "exception:%s", bo.l(e));
                AppMethodBeat.o(57836);
            }
        }

        public static void keep_readShort(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(57837);
            try {
                field.setShort(obj, (short) parcel.readInt());
                AppMethodBeat.o(57837);
            } catch (Exception e) {
                ab.e("MicroMsg.MCacheItem", "exception:%s", bo.l(e));
                AppMethodBeat.o(57837);
            }
        }

        public static void keep_readBoolean(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(57838);
            try {
                field.setBoolean(obj, parcel.readInt() != 0);
                AppMethodBeat.o(57838);
            } catch (Exception e) {
                ab.e("MicroMsg.MCacheItem", "exception:%s", bo.l(e));
                AppMethodBeat.o(57838);
            }
        }

        public static void keep_readInt(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(57839);
            try {
                field.setInt(obj, parcel.readInt());
                AppMethodBeat.o(57839);
            } catch (Exception e) {
                ab.e("MicroMsg.MCacheItem", "exception:%s", bo.l(e));
                AppMethodBeat.o(57839);
            }
        }

        public static void keep_readFloat(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(57840);
            try {
                field.setFloat(obj, parcel.readFloat());
                AppMethodBeat.o(57840);
            } catch (Exception e) {
                ab.e("MicroMsg.MCacheItem", "exception:%s", bo.l(e));
                AppMethodBeat.o(57840);
            }
        }

        public static void keep_readDouble(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(57841);
            try {
                field.setDouble(obj, parcel.readDouble());
                AppMethodBeat.o(57841);
            } catch (Exception e) {
                ab.e("MicroMsg.MCacheItem", "exception:%s", bo.l(e));
                AppMethodBeat.o(57841);
            }
        }

        public static void keep_readLong(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(57842);
            try {
                field.set(obj, Long.valueOf(parcel.readLong()));
                AppMethodBeat.o(57842);
            } catch (Exception e) {
                ab.e("MicroMsg.MCacheItem", "exception:%s", bo.l(e));
                AppMethodBeat.o(57842);
            }
        }

        public static void keep_readString(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.i(57843);
            try {
                field.set(obj, parcel.readString());
                AppMethodBeat.o(57843);
            } catch (Exception e) {
                ab.e("MicroMsg.MCacheItem", "exception:%s", bo.l(e));
                AppMethodBeat.o(57843);
            }
        }
    }

    static {
        AppMethodBeat.i(57848);
        AppMethodBeat.o(57848);
    }

    public MCacheItem(Parcel parcel) {
        AppMethodBeat.i(57845);
        this.efu = c(parcel);
        AppMethodBeat.o(57845);
    }

    public MCacheItem(c cVar) {
        this.efu = cVar;
    }

    private c c(Parcel parcel) {
        AppMethodBeat.i(57846);
        try {
            Class cls = Class.forName(parcel.readString());
            try {
                this.efu = (c) cls.newInstance();
            } catch (Exception e) {
            }
            for (Field type : c.ax(cls).xDb) {
                Method method = (Method) a.efw.get(type.getType());
                if (method != null) {
                    try {
                        method.invoke(null, new Object[]{parcel, type, this.efu});
                    } catch (Exception e2) {
                        ab.e("MicroMsg.MCacheItem", "exception:%s", bo.l(e2));
                    }
                }
            }
            c cVar = this.efu;
            AppMethodBeat.o(57846);
            return cVar;
        } catch (Exception e22) {
            ab.e("MicroMsg.MCacheItem", "exception:%s", bo.l(e22));
            AppMethodBeat.o(57846);
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(57847);
        parcel.writeString(this.efu.getClass().getName());
        for (Field type : c.ax(this.efu.getClass()).xDb) {
            Method method = (Method) a.efv.get(type.getType());
            if (method != null) {
                try {
                    method.invoke(null, new Object[]{parcel, type, this.efu});
                } catch (Exception e) {
                    ab.e("MicroMsg.MCacheItem", "exception:%s", bo.l(e));
                }
            }
        }
        AppMethodBeat.o(57847);
    }
}
