package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.e;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public final class aq {
    public boolean mInit = false;
    public String xXM;
    public int xXN = 2;
    public int xXO = 32;
    HashMap<String, String> xXP = new HashMap();
    public HashMap<String, ArrayList<String>> xXQ = new HashMap();
    public HashMap<String, String> xXR = new HashMap();
    public HashMap<String, ArrayList<a>> xXS = new HashMap();
    public Comparator xXT = new Comparator<a>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            a aVar = (a) obj;
            a aVar2 = (a) obj2;
            if (aVar == null && aVar2 == null) {
                return 0;
            }
            if (aVar != null) {
                if (aVar2 == null) {
                    return 1;
                }
                if (aVar.index == aVar2.index) {
                    return 0;
                }
                if (aVar.index > aVar2.index) {
                    return 1;
                }
            }
            return -1;
        }
    };

    public class a {
        public String cvZ;
        int index;

        a(String str, int i) {
            this.cvZ = str;
            this.index = i;
        }
    }

    public aq() {
        AppMethodBeat.i(62703);
        AppMethodBeat.o(62703);
    }

    public final void clear() {
        AppMethodBeat.i(62704);
        if (this.xXP != null) {
            this.xXP.clear();
        }
        if (this.xXQ != null) {
            this.xXQ.clear();
        }
        if (this.xXR != null) {
            this.xXR.clear();
        }
        if (this.xXS != null) {
            this.xXS.clear();
        }
        AppMethodBeat.o(62704);
    }

    public final void dsY() {
        AppMethodBeat.i(62705);
        d.xDH.a(new Runnable() {
            public final void run() {
                int i;
                String str;
                ArrayList arrayList;
                AppMethodBeat.i(62701);
                long currentTimeMillis = System.currentTimeMillis();
                aq aqVar = aq.this;
                aqVar.clear();
                Cursor cursor = null;
                try {
                    cursor = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().xYx.baR();
                    if (cursor != null && cursor.moveToFirst()) {
                        int count = cursor.getCount();
                        for (i = 0; i < count; i++) {
                            e eVar = new e();
                            eVar.d(cursor);
                            str = eVar.field_desc;
                            if (!bo.isNullOrNil(str)) {
                                aqVar.xXR.put(str.toLowerCase(), eVar.field_groupID);
                                arrayList = (ArrayList) aqVar.xXQ.get(eVar.field_groupID);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(eVar.field_desc);
                                aqVar.xXQ.put(eVar.field_groupID, arrayList);
                            }
                            cursor.moveToNext();
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.emoji.EmojiDescNewMgr", bo.l(e));
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    AppMethodBeat.o(62701);
                }
                String toLowerCase = aa.dor().toLowerCase();
                String str2 = "default";
                aqVar.xXM = toLowerCase;
                cursor = null;
                String str3 = "select EmojiInfoDesc.desc,EmojiInfoDesc.md5,EmojiInfoDesc.lang,EmojiGroupInfo.lastUseTime,EmojiInfoDesc.groupId,EmojiGroupInfo.productID,EmojiGroupInfo.idx from EmojiInfoDesc,EmojiGroupInfo where EmojiInfoDesc.groupId=EmojiGroupInfo.productID and EmojiGroupInfo.status='7' order by EmojiGroupInfo.sort desc,EmojiGroupInfo.lastUseTime desc";
                try {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    cursor = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().xYp.rawQuery(str3, new String[0]);
                    ab.i("MicroMsg.emoji.EmojiDescNewMgr", "cpan[tryInit]  rawQuery use time:%s", (System.currentTimeMillis() - currentTimeMillis2));
                    if (cursor != null && cursor.moveToFirst()) {
                        cursor.moveToFirst();
                        int count2 = cursor.getCount();
                        for (i = 0; i < count2; i++) {
                            str = cursor.getString(cursor.getColumnIndex("desc"));
                            String string = cursor.getString(cursor.getColumnIndex("md5"));
                            String string2 = cursor.getString(cursor.getColumnIndex("lang"));
                            int i2 = cursor.getInt(cursor.getColumnIndex("idx"));
                            if (!(bo.isNullOrNil(str) || bo.isNullOrNil(string2) || (!string2.equals(toLowerCase) && !string2.equals(str2)))) {
                                string2 = str.toLowerCase();
                                if (aqVar.xXS.containsKey(string2)) {
                                    arrayList = (ArrayList) aqVar.xXS.get(string2);
                                    if (arrayList == null) {
                                        arrayList = new ArrayList();
                                    }
                                    arrayList.add(new a(string, i2));
                                } else {
                                    arrayList = new ArrayList();
                                    arrayList.add(new a(string, i2));
                                    aqVar.xXS.put(string2, arrayList);
                                }
                                aqVar.xXP.put(string, string2);
                            }
                            cursor.moveToNext();
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Exception e2) {
                    ab.w("MicroMsg.emoji.EmojiDescNewMgr", bo.l(e2));
                    if (cursor != null) {
                        cursor.close();
                    }
                } catch (Throwable th2) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    AppMethodBeat.o(62701);
                }
                aq.this.mInit = true;
                ab.i("MicroMsg.emoji.EmojiDescNewMgr", "cpan[newinit] all use time:%s", (System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(62701);
            }

            public final String toString() {
                AppMethodBeat.i(62702);
                String str = super.toString() + "|newinit";
                AppMethodBeat.o(62702);
                return str;
            }
        }, "MicroMsg.emoji.EmojiDescNewMgr|newinit");
        AppMethodBeat.o(62705);
    }

    public final String Jh(String str) {
        AppMethodBeat.i(62706);
        String Jh;
        if (this.xXP == null || !this.xXP.containsKey(str)) {
            Jh = ((com.tencent.mm.plugin.emoji.b.d) g.M(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiStorageMgr().xYp.Jh(str);
            AppMethodBeat.o(62706);
            return Jh;
        }
        Jh = (String) this.xXP.get(str);
        AppMethodBeat.o(62706);
        return Jh;
    }
}
