package com.tencent.p177mm.emoji.p227a;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.sync.EmojiUpdateReceiver;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.p207by.C45274a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C23505at;
import com.tencent.p177mm.storage.emotion.C30303d;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo.C30302a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: com.tencent.mm.emoji.a.a */
public final class C32497a {
    private static C32497a eyu;
    public ArrayList<EmojiGroupInfo> eyA = new ArrayList();
    public HashMap<String, ArrayList<EmojiInfo>> eyB = new HashMap();
    private boolean eyv = true;
    private boolean eyw = true;
    public boolean eyx = true;
    private boolean eyy = true;
    private boolean eyz = true;

    /* renamed from: OB */
    public static synchronized C32497a m53203OB() {
        C32497a c32497a;
        synchronized (C32497a.class) {
            AppMethodBeat.m2504i(62230);
            if (eyu == null) {
                eyu = new C32497a();
            }
            c32497a = eyu;
            AppMethodBeat.m2505o(62230);
        }
        return c32497a;
    }

    private C32497a() {
        AppMethodBeat.m2504i(62231);
        AppMethodBeat.m2505o(62231);
    }

    /* renamed from: bY */
    public final ArrayList<EmojiInfo> mo53136bY(boolean z) {
        ArrayList arrayList;
        AppMethodBeat.m2504i(62232);
        C4990ab.m7411d("MicroMsg.EmojiStorageCache", "onlySuccessEmoji: %s.", Boolean.valueOf(z));
        if (!this.eyB.containsKey("custom") || this.eyw) {
            Object obj;
            C4990ab.m7417i("MicroMsg.EmojiStorageCache", "getAllCustomEmoji: %s", Boolean.valueOf(this.eyw));
            if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
                C30303d c30303d = C23505at.dsZ().xYn;
                arrayList = new ArrayList();
                arrayList.addAll(c30303d.mo48563My(EmojiGroupInfo.yat));
                arrayList.addAll(c30303d.mo48563My(EmojiGroupInfo.yas));
                obj = arrayList;
            } else {
                obj = new ArrayList();
                Bundle call = C45274a.call(C45274a.getUri(), "getAllCustomEmoji", null, null);
                if (call != null) {
                    call.setClassLoader(EmojiInfo.class.getClassLoader());
                    if (call.containsKey("data")) {
                        ArrayList parcelableArrayList = call.getParcelableArrayList("data");
                        if (parcelableArrayList != null) {
                            obj.addAll(parcelableArrayList);
                            C4990ab.m7417i("MicroMsg.EmojiStorageCache", "[getAllCustomEmojiExport] size:%s", Integer.valueOf(parcelableArrayList.size()));
                        }
                    }
                }
            }
            this.eyB.put("custom", obj);
        }
        this.eyw = false;
        arrayList = (ArrayList) this.eyB.get("custom");
        if (arrayList != null && z) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                EmojiInfo emojiInfo = (EmojiInfo) it.next();
                if (C30302a.STATUS_SUCCESS != emojiInfo.duZ()) {
                    arrayList2.add(emojiInfo);
                }
            }
            arrayList.removeAll(arrayList2);
        }
        AppMethodBeat.m2505o(62232);
        return arrayList;
    }

    /* renamed from: OC */
    public final ArrayList<EmojiInfo> mo53134OC() {
        AppMethodBeat.m2504i(62233);
        if (!this.eyB.containsKey("download_custom") || this.eyv) {
            if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
                this.eyB.put("download_custom", (ArrayList) C23505at.dsZ().xYn.mo48590ps(true));
            } else {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("need get from main process");
                AppMethodBeat.m2505o(62233);
                throw unsupportedOperationException;
            }
        }
        this.eyv = false;
        ArrayList arrayList = (ArrayList) this.eyB.get("download_custom");
        AppMethodBeat.m2505o(62233);
        return arrayList;
    }

    /* renamed from: kS */
    public final ArrayList<EmojiInfo> mo53142kS(String str) {
        AppMethodBeat.m2504i(62234);
        if (this.eyx) {
            this.eyB.clear();
            this.eyx = false;
        }
        if (!this.eyB.containsKey(str)) {
            Object obj;
            if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
                obj = (ArrayList) C23505at.dsZ().xYn.mo48557Jg(str);
            } else {
                obj = new ArrayList();
                Bundle call = C45274a.call(C45274a.getUri(), "getEmojiListByGroupId", String.valueOf(str), null);
                if (call != null) {
                    call.setClassLoader(EmojiInfo.class.getClassLoader());
                    if (call.containsKey("data")) {
                        ArrayList parcelableArrayList = call.getParcelableArrayList("data");
                        if (parcelableArrayList != null) {
                            obj.addAll(parcelableArrayList);
                            C4990ab.m7417i("MicroMsg.EmojiStorageCache", "[getEmojiListByGroupIdExport] size%s", Integer.valueOf(parcelableArrayList.size()));
                        }
                    }
                }
            }
            this.eyB.put(str, obj);
        }
        ArrayList arrayList = (ArrayList) this.eyB.get(str);
        AppMethodBeat.m2505o(62234);
        return arrayList;
    }

    /* renamed from: OD */
    public final ArrayList<EmojiGroupInfo> mo53135OD() {
        ArrayList arrayList;
        AppMethodBeat.m2504i(62235);
        if (this.eyy) {
            if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
                this.eyA = C23505at.dsZ().xYo.duG();
            } else {
                arrayList = new ArrayList();
                Bundle call = C45274a.call(C45274a.getUri(), "getEmojiGroupInfoList", null, null);
                if (call != null) {
                    call.setClassLoader(EmojiGroupInfo.class.getClassLoader());
                    if (call.containsKey("data")) {
                        ArrayList parcelableArrayList = call.getParcelableArrayList("data");
                        if (parcelableArrayList != null) {
                            arrayList.addAll(parcelableArrayList);
                            C4990ab.m7417i("MicroMsg.EmojiStorageCache", "[getEmojiGroupInfoListExport] size: %s", Integer.valueOf(parcelableArrayList.size()));
                        }
                    }
                }
                this.eyA = arrayList;
            }
        }
        this.eyy = false;
        arrayList = this.eyA;
        AppMethodBeat.m2505o(62235);
        return arrayList;
    }

    /* renamed from: bZ */
    public final ArrayList<EmojiInfo> mo53137bZ(boolean z) {
        ArrayList arrayList;
        AppMethodBeat.m2504i(62236);
        C4990ab.m7417i("MicroMsg.EmojiStorageCache", "getCaptureEmoji: needUpdateCaptureEmoji %s withFailed %s.", Boolean.valueOf(this.eyz), Boolean.valueOf(z));
        if (!this.eyB.containsKey("capture") || this.eyz) {
            if (((C6624h) C1720g.m3533RM().mo5224Rn()).mo5181SG()) {
                C30303d c30303d = C23505at.dsZ().xYn;
                arrayList = new ArrayList();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("select * from EmojiInfo where groupId = \"capture\"");
                stringBuilder.append(" and state != ").append(EmojiInfo.zZc);
                stringBuilder.append(" order by idx asc ");
                Cursor rawQuery = c30303d.bSd.rawQuery(stringBuilder.toString(), null);
                if (rawQuery != null) {
                    if (rawQuery.moveToFirst()) {
                        do {
                            EmojiInfo emojiInfo = new EmojiInfo();
                            emojiInfo.mo8995d(rawQuery);
                            arrayList.add(emojiInfo);
                        } while (rawQuery.moveToNext());
                    }
                    rawQuery.close();
                }
                arrayList = arrayList;
            } else {
                arrayList = new ArrayList();
                Bundle call = C45274a.call(C45274a.getUri(), "getCaptureEmoji", null, null);
                if (call != null) {
                    call.setClassLoader(EmojiInfo.class.getClassLoader());
                    if (call.containsKey("key_data")) {
                        ArrayList parcelableArrayList = call.getParcelableArrayList("key_data");
                        if (parcelableArrayList != null) {
                            arrayList.addAll(parcelableArrayList);
                            C4990ab.m7417i("MicroMsg.EmojiStorageCache", "[getCaptureEmojiExport] size:%s", Integer.valueOf(parcelableArrayList.size()));
                        }
                    }
                }
            }
            C4990ab.m7417i("MicroMsg.EmojiStorageCache", "getCaptureEmoji: %s size %s", Boolean.valueOf(this.eyz), Integer.valueOf(arrayList.size()));
            this.eyB.put("capture", arrayList);
        }
        this.eyz = false;
        arrayList = (ArrayList) this.eyB.get("capture");
        if (z) {
            String str = "MicroMsg.EmojiStorageCache";
            String str2 = "getCaptureEmoji list size: %s.";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
            C4990ab.m7411d(str, str2, objArr);
            AppMethodBeat.m2505o(62236);
            return arrayList;
        }
        ArrayList<EmojiInfo> arrayList2 = new ArrayList();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                EmojiInfo emojiInfo2 = (EmojiInfo) it.next();
                if (emojiInfo2.duZ() == C30302a.STATUS_SUCCESS) {
                    arrayList2.add(emojiInfo2);
                }
            }
        }
        C4990ab.m7411d("MicroMsg.EmojiStorageCache", "getCaptureEmoji result size: %s.", Integer.valueOf(arrayList2.size()));
        AppMethodBeat.m2505o(62236);
        return arrayList2;
    }

    /* renamed from: ca */
    public final void mo53138ca(boolean z) {
        AppMethodBeat.m2504i(62237);
        this.eyw = true;
        C4990ab.m7417i("MicroMsg.EmojiStorageCache", "setNeedUpdateAllCustomEmoji %s", Boolean.valueOf(z));
        if (z) {
            Intent intent = new Intent();
            intent.setAction(EmojiUpdateReceiver.ACTION);
            intent.putExtra(EmojiUpdateReceiver.ezN, EmojiUpdateReceiver.ezO);
            C4996ah.getContext().sendBroadcast(intent);
        }
        AppMethodBeat.m2505o(62237);
    }

    /* renamed from: cb */
    public final void mo53139cb(boolean z) {
        AppMethodBeat.m2504i(62238);
        this.eyv = true;
        C4990ab.m7417i("MicroMsg.EmojiStorageCache", "setNeedUpdateAllCustomEmoji %s", Boolean.valueOf(z));
        if (z) {
            Intent intent = new Intent();
            intent.setAction(EmojiUpdateReceiver.ACTION);
            intent.putExtra(EmojiUpdateReceiver.ezN, EmojiUpdateReceiver.ezP);
            C4996ah.getContext().sendBroadcast(intent);
        }
        AppMethodBeat.m2505o(62238);
    }

    /* renamed from: cc */
    public final void mo53140cc(boolean z) {
        AppMethodBeat.m2504i(62239);
        this.eyy = true;
        C4990ab.m7417i("MicroMsg.EmojiStorageCache", "setNeedUpdateGroupInfo: %s", Boolean.valueOf(z));
        if (z) {
            Intent intent = new Intent();
            intent.setAction(EmojiUpdateReceiver.ACTION);
            intent.putExtra(EmojiUpdateReceiver.ezN, EmojiUpdateReceiver.ezR);
            C4996ah.getContext().sendBroadcast(intent);
        }
        AppMethodBeat.m2505o(62239);
    }

    /* renamed from: cd */
    public final void mo53141cd(boolean z) {
        AppMethodBeat.m2504i(62240);
        this.eyz = true;
        if (z) {
            String str = EmojiUpdateReceiver.ezS;
            Intent intent = new Intent();
            intent.setAction(EmojiUpdateReceiver.ACTION);
            intent.putExtra(EmojiUpdateReceiver.ezN, str);
            C4996ah.getContext().sendBroadcast(intent);
        }
        AppMethodBeat.m2505o(62240);
    }
}
