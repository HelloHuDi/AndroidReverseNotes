package com.tencent.p177mm.cache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.cache.MCacheItem */
public class MCacheItem implements Parcelable {
    public static final Creator<MCacheItem> CREATOR = new C181271();
    private C4925c efu;

    /* renamed from: com.tencent.mm.cache.MCacheItem$1 */
    static class C181271 implements Creator<MCacheItem> {
        C181271() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MCacheItem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(57827);
            MCacheItem mCacheItem = new MCacheItem(parcel);
            AppMethodBeat.m2505o(57827);
            return mCacheItem;
        }
    }

    /* renamed from: com.tencent.mm.cache.MCacheItem$a */
    static class C26000a {
        public static Map<Class<?>, Method> efv = new HashMap();
        public static Map<Class<?>, Method> efw = new HashMap();

        C26000a() {
        }

        static {
            AppMethodBeat.m2504i(57844);
            try {
                efv.put(byte[].class, C26000a.class.getMethod("keep_writeByteArray", new Class[]{Parcel.class, Field.class, Object.class}));
                efv.put(Short.TYPE, C26000a.class.getMethod("keep_writeShort", new Class[]{Parcel.class, Field.class, Object.class}));
                efv.put(Short.class, C26000a.class.getMethod("keep_writeShort", new Class[]{Parcel.class, Field.class, Object.class}));
                efv.put(Boolean.TYPE, C26000a.class.getMethod("keep_writeBoolean", new Class[]{Parcel.class, Field.class, Object.class}));
                efv.put(Boolean.class, C26000a.class.getMethod("keep_writeBoolean", new Class[]{Parcel.class, Field.class, Object.class}));
                efv.put(Integer.TYPE, C26000a.class.getMethod("keep_writeInt", new Class[]{Parcel.class, Field.class, Object.class}));
                efv.put(Integer.class, C26000a.class.getMethod("keep_writeInt", new Class[]{Parcel.class, Field.class, Object.class}));
                efv.put(Float.TYPE, C26000a.class.getMethod("keep_writeFloat", new Class[]{Parcel.class, Field.class, Object.class}));
                efv.put(Float.class, C26000a.class.getMethod("keep_writeFloat", new Class[]{Parcel.class, Field.class, Object.class}));
                efv.put(Double.TYPE, C26000a.class.getMethod("keep_writeDouble", new Class[]{Parcel.class, Field.class, Object.class}));
                efv.put(Double.class, C26000a.class.getMethod("keep_writeDouble", new Class[]{Parcel.class, Field.class, Object.class}));
                efv.put(Long.TYPE, C26000a.class.getMethod("keep_writeLong", new Class[]{Parcel.class, Field.class, Object.class}));
                efv.put(Long.class, C26000a.class.getMethod("keep_writeLong", new Class[]{Parcel.class, Field.class, Object.class}));
                efv.put(String.class, C26000a.class.getMethod("keep_writeString", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(byte[].class, C26000a.class.getMethod("keep_readByteArray", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(Short.TYPE, C26000a.class.getMethod("keep_readShort", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(Short.class, C26000a.class.getMethod("keep_readShort", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(Boolean.TYPE, C26000a.class.getMethod("keep_readBoolean", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(Boolean.class, C26000a.class.getMethod("keep_readBoolean", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(Integer.TYPE, C26000a.class.getMethod("keep_readInt", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(Integer.class, C26000a.class.getMethod("keep_readInt", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(Float.TYPE, C26000a.class.getMethod("keep_readFloat", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(Float.class, C26000a.class.getMethod("keep_readFloat", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(Double.TYPE, C26000a.class.getMethod("keep_readDouble", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(Double.class, C26000a.class.getMethod("keep_readDouble", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(Long.TYPE, C26000a.class.getMethod("keep_readLong", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(Long.class, C26000a.class.getMethod("keep_readLong", new Class[]{Parcel.class, Field.class, Object.class}));
                efw.put(String.class, C26000a.class.getMethod("keep_readString", new Class[]{Parcel.class, Field.class, Object.class}));
                AppMethodBeat.m2505o(57844);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MCacheItem", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(57844);
            }
        }

        public static void keep_writeByteArray(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.m2504i(57828);
            try {
                parcel.writeByteArray((byte[]) field.get(obj));
                AppMethodBeat.m2505o(57828);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MCacheItem", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(57828);
            }
        }

        public static void keep_writeShort(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.m2504i(57829);
            try {
                parcel.writeInt(field.getShort(obj));
                AppMethodBeat.m2505o(57829);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MCacheItem", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(57829);
            }
        }

        public static void keep_writeBoolean(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.m2504i(57830);
            try {
                parcel.writeInt(field.getBoolean(obj) ? 1 : 0);
                AppMethodBeat.m2505o(57830);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MCacheItem", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(57830);
            }
        }

        public static void keep_writeInt(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.m2504i(57831);
            try {
                parcel.writeInt(field.getInt(obj));
                AppMethodBeat.m2505o(57831);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MCacheItem", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(57831);
            }
        }

        public static void keep_writeFloat(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.m2504i(57832);
            try {
                parcel.writeFloat(field.getFloat(obj));
                AppMethodBeat.m2505o(57832);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MCacheItem", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(57832);
            }
        }

        public static void keep_writeDouble(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.m2504i(57833);
            try {
                parcel.writeDouble(field.getDouble(obj));
                AppMethodBeat.m2505o(57833);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MCacheItem", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(57833);
            }
        }

        public static void keep_writeLong(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.m2504i(57834);
            try {
                parcel.writeLong(field.getLong(obj));
                AppMethodBeat.m2505o(57834);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MCacheItem", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(57834);
            }
        }

        public static void keep_writeString(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.m2504i(57835);
            try {
                parcel.writeString((String) field.get(obj));
                AppMethodBeat.m2505o(57835);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MCacheItem", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(57835);
            }
        }

        public static void keep_readByteArray(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.m2504i(57836);
            try {
                field.set(obj, parcel.createByteArray());
                AppMethodBeat.m2505o(57836);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MCacheItem", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(57836);
            }
        }

        public static void keep_readShort(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.m2504i(57837);
            try {
                field.setShort(obj, (short) parcel.readInt());
                AppMethodBeat.m2505o(57837);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MCacheItem", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(57837);
            }
        }

        public static void keep_readBoolean(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.m2504i(57838);
            try {
                field.setBoolean(obj, parcel.readInt() != 0);
                AppMethodBeat.m2505o(57838);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MCacheItem", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(57838);
            }
        }

        public static void keep_readInt(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.m2504i(57839);
            try {
                field.setInt(obj, parcel.readInt());
                AppMethodBeat.m2505o(57839);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MCacheItem", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(57839);
            }
        }

        public static void keep_readFloat(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.m2504i(57840);
            try {
                field.setFloat(obj, parcel.readFloat());
                AppMethodBeat.m2505o(57840);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MCacheItem", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(57840);
            }
        }

        public static void keep_readDouble(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.m2504i(57841);
            try {
                field.setDouble(obj, parcel.readDouble());
                AppMethodBeat.m2505o(57841);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MCacheItem", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(57841);
            }
        }

        public static void keep_readLong(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.m2504i(57842);
            try {
                field.set(obj, Long.valueOf(parcel.readLong()));
                AppMethodBeat.m2505o(57842);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MCacheItem", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(57842);
            }
        }

        public static void keep_readString(Parcel parcel, Field field, Object obj) {
            AppMethodBeat.m2504i(57843);
            try {
                field.set(obj, parcel.readString());
                AppMethodBeat.m2505o(57843);
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.MCacheItem", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(57843);
            }
        }
    }

    static {
        AppMethodBeat.m2504i(57848);
        AppMethodBeat.m2505o(57848);
    }

    public MCacheItem(Parcel parcel) {
        AppMethodBeat.m2504i(57845);
        this.efu = m41492c(parcel);
        AppMethodBeat.m2505o(57845);
    }

    public MCacheItem(C4925c c4925c) {
        this.efu = c4925c;
    }

    /* renamed from: c */
    private C4925c m41492c(Parcel parcel) {
        AppMethodBeat.m2504i(57846);
        try {
            Class cls = Class.forName(parcel.readString());
            try {
                this.efu = (C4925c) cls.newInstance();
            } catch (Exception e) {
            }
            for (Field type : C4925c.m7296ax(cls).xDb) {
                Method method = (Method) C26000a.efw.get(type.getType());
                if (method != null) {
                    try {
                        method.invoke(null, new Object[]{parcel, type, this.efu});
                    } catch (Exception e2) {
                        C4990ab.m7413e("MicroMsg.MCacheItem", "exception:%s", C5046bo.m7574l(e2));
                    }
                }
            }
            C4925c c4925c = this.efu;
            AppMethodBeat.m2505o(57846);
            return c4925c;
        } catch (Exception e22) {
            C4990ab.m7413e("MicroMsg.MCacheItem", "exception:%s", C5046bo.m7574l(e22));
            AppMethodBeat.m2505o(57846);
            return null;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(57847);
        parcel.writeString(this.efu.getClass().getName());
        for (Field type : C4925c.m7296ax(this.efu.getClass()).xDb) {
            Method method = (Method) C26000a.efv.get(type.getType());
            if (method != null) {
                try {
                    method.invoke(null, new Object[]{parcel, type, this.efu});
                } catch (Exception e) {
                    C4990ab.m7413e("MicroMsg.MCacheItem", "exception:%s", C5046bo.m7574l(e));
                }
            }
        }
        AppMethodBeat.m2505o(57847);
    }
}
