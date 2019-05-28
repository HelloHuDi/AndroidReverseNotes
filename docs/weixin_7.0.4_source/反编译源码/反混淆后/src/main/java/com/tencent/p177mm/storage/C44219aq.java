package com.tencent.p177mm.storage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.C30304e;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/* renamed from: com.tencent.mm.storage.aq */
public final class C44219aq {
    public boolean mInit = false;
    public String xXM;
    public int xXN = 2;
    public int xXO = 32;
    HashMap<String, String> xXP = new HashMap();
    public HashMap<String, ArrayList<String>> xXQ = new HashMap();
    public HashMap<String, String> xXR = new HashMap();
    public HashMap<String, ArrayList<C44220a>> xXS = new HashMap();
    public Comparator xXT = new C359951();

    /* renamed from: com.tencent.mm.storage.aq$2 */
    class C235032 implements Runnable {
        C235032() {
        }

        public final void run() {
            int i;
            String str;
            ArrayList arrayList;
            AppMethodBeat.m2504i(62701);
            long currentTimeMillis = System.currentTimeMillis();
            C44219aq c44219aq = C44219aq.this;
            c44219aq.clear();
            Cursor cursor = null;
            try {
                cursor = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYx.baR();
                if (cursor != null && cursor.moveToFirst()) {
                    int count = cursor.getCount();
                    for (i = 0; i < count; i++) {
                        C30304e c30304e = new C30304e();
                        c30304e.mo8995d(cursor);
                        str = c30304e.field_desc;
                        if (!C5046bo.isNullOrNil(str)) {
                            c44219aq.xXR.put(str.toLowerCase(), c30304e.field_groupID);
                            arrayList = (ArrayList) c44219aq.xXQ.get(c30304e.field_groupID);
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(c30304e.field_desc);
                            c44219aq.xXQ.put(c30304e.field_groupID, arrayList);
                        }
                        cursor.moveToNext();
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.emoji.EmojiDescNewMgr", C5046bo.m7574l(e));
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.m2505o(62701);
            }
            String toLowerCase = C4988aa.dor().toLowerCase();
            String str2 = "default";
            c44219aq.xXM = toLowerCase;
            cursor = null;
            String str3 = "select EmojiInfoDesc.desc,EmojiInfoDesc.md5,EmojiInfoDesc.lang,EmojiGroupInfo.lastUseTime,EmojiInfoDesc.groupId,EmojiGroupInfo.productID,EmojiGroupInfo.idx from EmojiInfoDesc,EmojiGroupInfo where EmojiInfoDesc.groupId=EmojiGroupInfo.productID and EmojiGroupInfo.status='7' order by EmojiGroupInfo.sort desc,EmojiGroupInfo.lastUseTime desc";
            try {
                long currentTimeMillis2 = System.currentTimeMillis();
                cursor = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYp.rawQuery(str3, new String[0]);
                C4990ab.m7417i("MicroMsg.emoji.EmojiDescNewMgr", "cpan[tryInit]  rawQuery use time:%s", (System.currentTimeMillis() - currentTimeMillis2));
                if (cursor != null && cursor.moveToFirst()) {
                    cursor.moveToFirst();
                    int count2 = cursor.getCount();
                    for (i = 0; i < count2; i++) {
                        str = cursor.getString(cursor.getColumnIndex("desc"));
                        String string = cursor.getString(cursor.getColumnIndex("md5"));
                        String string2 = cursor.getString(cursor.getColumnIndex("lang"));
                        int i2 = cursor.getInt(cursor.getColumnIndex("idx"));
                        if (!(C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(string2) || (!string2.equals(toLowerCase) && !string2.equals(str2)))) {
                            string2 = str.toLowerCase();
                            if (c44219aq.xXS.containsKey(string2)) {
                                arrayList = (ArrayList) c44219aq.xXS.get(string2);
                                if (arrayList == null) {
                                    arrayList = new ArrayList();
                                }
                                arrayList.add(new C44220a(string, i2));
                            } else {
                                arrayList = new ArrayList();
                                arrayList.add(new C44220a(string, i2));
                                c44219aq.xXS.put(string2, arrayList);
                            }
                            c44219aq.xXP.put(string, string2);
                        }
                        cursor.moveToNext();
                    }
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e2) {
                C4990ab.m7420w("MicroMsg.emoji.EmojiDescNewMgr", C5046bo.m7574l(e2));
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th2) {
                if (cursor != null) {
                    cursor.close();
                }
                AppMethodBeat.m2505o(62701);
            }
            C44219aq.this.mInit = true;
            C4990ab.m7417i("MicroMsg.emoji.EmojiDescNewMgr", "cpan[newinit] all use time:%s", (System.currentTimeMillis() - currentTimeMillis));
            AppMethodBeat.m2505o(62701);
        }

        public final String toString() {
            AppMethodBeat.m2504i(62702);
            String str = super.toString() + "|newinit";
            AppMethodBeat.m2505o(62702);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.storage.aq$1 */
    class C359951 implements Comparator<C44220a> {
        C359951() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            C44220a c44220a = (C44220a) obj;
            C44220a c44220a2 = (C44220a) obj2;
            if (c44220a == null && c44220a2 == null) {
                return 0;
            }
            if (c44220a != null) {
                if (c44220a2 == null) {
                    return 1;
                }
                if (c44220a.index == c44220a2.index) {
                    return 0;
                }
                if (c44220a.index > c44220a2.index) {
                    return 1;
                }
            }
            return -1;
        }
    }

    /* renamed from: com.tencent.mm.storage.aq$a */
    public class C44220a {
        public String cvZ;
        int index;

        C44220a(String str, int i) {
            this.cvZ = str;
            this.index = i;
        }
    }

    public C44219aq() {
        AppMethodBeat.m2504i(62703);
        AppMethodBeat.m2505o(62703);
    }

    public final void clear() {
        AppMethodBeat.m2504i(62704);
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
        AppMethodBeat.m2505o(62704);
    }

    public final void dsY() {
        AppMethodBeat.m2504i(62705);
        C7305d.xDH.mo10140a(new C235032(), "MicroMsg.emoji.EmojiDescNewMgr|newinit");
        AppMethodBeat.m2505o(62705);
    }

    /* renamed from: Jh */
    public final String mo69856Jh(String str) {
        AppMethodBeat.m2504i(62706);
        String Jh;
        if (this.xXP == null || !this.xXP.containsKey(str)) {
            Jh = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiStorageMgr().xYp.mo39182Jh(str);
            AppMethodBeat.m2505o(62706);
            return Jh;
        }
        Jh = (String) this.xXP.get(str);
        AppMethodBeat.m2505o(62706);
        return Jh;
    }
}
