package com.tencent.mm.emoji.a;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.sync.EmojiUpdateReceiver;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class a {
    private static a eyu;
    public ArrayList<EmojiGroupInfo> eyA = new ArrayList();
    public HashMap<String, ArrayList<EmojiInfo>> eyB = new HashMap();
    private boolean eyv = true;
    private boolean eyw = true;
    public boolean eyx = true;
    private boolean eyy = true;
    private boolean eyz = true;

    public static synchronized a OB() {
        a aVar;
        synchronized (a.class) {
            AppMethodBeat.i(62230);
            if (eyu == null) {
                eyu = new a();
            }
            aVar = eyu;
            AppMethodBeat.o(62230);
        }
        return aVar;
    }

    private a() {
        AppMethodBeat.i(62231);
        AppMethodBeat.o(62231);
    }

    public final ArrayList<EmojiInfo> bY(boolean z) {
        ArrayList arrayList;
        AppMethodBeat.i(62232);
        ab.d("MicroMsg.EmojiStorageCache", "onlySuccessEmoji: %s.", Boolean.valueOf(z));
        if (!this.eyB.containsKey("custom") || this.eyw) {
            Object obj;
            ab.i("MicroMsg.EmojiStorageCache", "getAllCustomEmoji: %s", Boolean.valueOf(this.eyw));
            if (((h) g.RM().Rn()).SG()) {
                d dVar = at.dsZ().xYn;
                arrayList = new ArrayList();
                arrayList.addAll(dVar.My(EmojiGroupInfo.yat));
                arrayList.addAll(dVar.My(EmojiGroupInfo.yas));
                obj = arrayList;
            } else {
                obj = new ArrayList();
                Bundle call = com.tencent.mm.by.a.call(com.tencent.mm.by.a.getUri(), "getAllCustomEmoji", null, null);
                if (call != null) {
                    call.setClassLoader(EmojiInfo.class.getClassLoader());
                    if (call.containsKey("data")) {
                        ArrayList parcelableArrayList = call.getParcelableArrayList("data");
                        if (parcelableArrayList != null) {
                            obj.addAll(parcelableArrayList);
                            ab.i("MicroMsg.EmojiStorageCache", "[getAllCustomEmojiExport] size:%s", Integer.valueOf(parcelableArrayList.size()));
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
                if (com.tencent.mm.storage.emotion.EmojiInfo.a.STATUS_SUCCESS != emojiInfo.duZ()) {
                    arrayList2.add(emojiInfo);
                }
            }
            arrayList.removeAll(arrayList2);
        }
        AppMethodBeat.o(62232);
        return arrayList;
    }

    public final ArrayList<EmojiInfo> OC() {
        AppMethodBeat.i(62233);
        if (!this.eyB.containsKey("download_custom") || this.eyv) {
            if (((h) g.RM().Rn()).SG()) {
                this.eyB.put("download_custom", (ArrayList) at.dsZ().xYn.ps(true));
            } else {
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("need get from main process");
                AppMethodBeat.o(62233);
                throw unsupportedOperationException;
            }
        }
        this.eyv = false;
        ArrayList arrayList = (ArrayList) this.eyB.get("download_custom");
        AppMethodBeat.o(62233);
        return arrayList;
    }

    public final ArrayList<EmojiInfo> kS(String str) {
        AppMethodBeat.i(62234);
        if (this.eyx) {
            this.eyB.clear();
            this.eyx = false;
        }
        if (!this.eyB.containsKey(str)) {
            Object obj;
            if (((h) g.RM().Rn()).SG()) {
                obj = (ArrayList) at.dsZ().xYn.Jg(str);
            } else {
                obj = new ArrayList();
                Bundle call = com.tencent.mm.by.a.call(com.tencent.mm.by.a.getUri(), "getEmojiListByGroupId", String.valueOf(str), null);
                if (call != null) {
                    call.setClassLoader(EmojiInfo.class.getClassLoader());
                    if (call.containsKey("data")) {
                        ArrayList parcelableArrayList = call.getParcelableArrayList("data");
                        if (parcelableArrayList != null) {
                            obj.addAll(parcelableArrayList);
                            ab.i("MicroMsg.EmojiStorageCache", "[getEmojiListByGroupIdExport] size%s", Integer.valueOf(parcelableArrayList.size()));
                        }
                    }
                }
            }
            this.eyB.put(str, obj);
        }
        ArrayList arrayList = (ArrayList) this.eyB.get(str);
        AppMethodBeat.o(62234);
        return arrayList;
    }

    public final ArrayList<EmojiGroupInfo> OD() {
        ArrayList arrayList;
        AppMethodBeat.i(62235);
        if (this.eyy) {
            if (((h) g.RM().Rn()).SG()) {
                this.eyA = at.dsZ().xYo.duG();
            } else {
                arrayList = new ArrayList();
                Bundle call = com.tencent.mm.by.a.call(com.tencent.mm.by.a.getUri(), "getEmojiGroupInfoList", null, null);
                if (call != null) {
                    call.setClassLoader(EmojiGroupInfo.class.getClassLoader());
                    if (call.containsKey("data")) {
                        ArrayList parcelableArrayList = call.getParcelableArrayList("data");
                        if (parcelableArrayList != null) {
                            arrayList.addAll(parcelableArrayList);
                            ab.i("MicroMsg.EmojiStorageCache", "[getEmojiGroupInfoListExport] size: %s", Integer.valueOf(parcelableArrayList.size()));
                        }
                    }
                }
                this.eyA = arrayList;
            }
        }
        this.eyy = false;
        arrayList = this.eyA;
        AppMethodBeat.o(62235);
        return arrayList;
    }

    public final ArrayList<EmojiInfo> bZ(boolean z) {
        ArrayList arrayList;
        AppMethodBeat.i(62236);
        ab.i("MicroMsg.EmojiStorageCache", "getCaptureEmoji: needUpdateCaptureEmoji %s withFailed %s.", Boolean.valueOf(this.eyz), Boolean.valueOf(z));
        if (!this.eyB.containsKey("capture") || this.eyz) {
            if (((h) g.RM().Rn()).SG()) {
                d dVar = at.dsZ().xYn;
                arrayList = new ArrayList();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("select * from EmojiInfo where groupId = \"capture\"");
                stringBuilder.append(" and state != ").append(EmojiInfo.zZc);
                stringBuilder.append(" order by idx asc ");
                Cursor rawQuery = dVar.bSd.rawQuery(stringBuilder.toString(), null);
                if (rawQuery != null) {
                    if (rawQuery.moveToFirst()) {
                        do {
                            EmojiInfo emojiInfo = new EmojiInfo();
                            emojiInfo.d(rawQuery);
                            arrayList.add(emojiInfo);
                        } while (rawQuery.moveToNext());
                    }
                    rawQuery.close();
                }
                arrayList = arrayList;
            } else {
                arrayList = new ArrayList();
                Bundle call = com.tencent.mm.by.a.call(com.tencent.mm.by.a.getUri(), "getCaptureEmoji", null, null);
                if (call != null) {
                    call.setClassLoader(EmojiInfo.class.getClassLoader());
                    if (call.containsKey("key_data")) {
                        ArrayList parcelableArrayList = call.getParcelableArrayList("key_data");
                        if (parcelableArrayList != null) {
                            arrayList.addAll(parcelableArrayList);
                            ab.i("MicroMsg.EmojiStorageCache", "[getCaptureEmojiExport] size:%s", Integer.valueOf(parcelableArrayList.size()));
                        }
                    }
                }
            }
            ab.i("MicroMsg.EmojiStorageCache", "getCaptureEmoji: %s size %s", Boolean.valueOf(this.eyz), Integer.valueOf(arrayList.size()));
            this.eyB.put("capture", arrayList);
        }
        this.eyz = false;
        arrayList = (ArrayList) this.eyB.get("capture");
        if (z) {
            String str = "MicroMsg.EmojiStorageCache";
            String str2 = "getCaptureEmoji list size: %s.";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
            ab.d(str, str2, objArr);
            AppMethodBeat.o(62236);
            return arrayList;
        }
        ArrayList<EmojiInfo> arrayList2 = new ArrayList();
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                EmojiInfo emojiInfo2 = (EmojiInfo) it.next();
                if (emojiInfo2.duZ() == com.tencent.mm.storage.emotion.EmojiInfo.a.STATUS_SUCCESS) {
                    arrayList2.add(emojiInfo2);
                }
            }
        }
        ab.d("MicroMsg.EmojiStorageCache", "getCaptureEmoji result size: %s.", Integer.valueOf(arrayList2.size()));
        AppMethodBeat.o(62236);
        return arrayList2;
    }

    public final void ca(boolean z) {
        AppMethodBeat.i(62237);
        this.eyw = true;
        ab.i("MicroMsg.EmojiStorageCache", "setNeedUpdateAllCustomEmoji %s", Boolean.valueOf(z));
        if (z) {
            Intent intent = new Intent();
            intent.setAction(EmojiUpdateReceiver.ACTION);
            intent.putExtra(EmojiUpdateReceiver.ezN, EmojiUpdateReceiver.ezO);
            ah.getContext().sendBroadcast(intent);
        }
        AppMethodBeat.o(62237);
    }

    public final void cb(boolean z) {
        AppMethodBeat.i(62238);
        this.eyv = true;
        ab.i("MicroMsg.EmojiStorageCache", "setNeedUpdateAllCustomEmoji %s", Boolean.valueOf(z));
        if (z) {
            Intent intent = new Intent();
            intent.setAction(EmojiUpdateReceiver.ACTION);
            intent.putExtra(EmojiUpdateReceiver.ezN, EmojiUpdateReceiver.ezP);
            ah.getContext().sendBroadcast(intent);
        }
        AppMethodBeat.o(62238);
    }

    public final void cc(boolean z) {
        AppMethodBeat.i(62239);
        this.eyy = true;
        ab.i("MicroMsg.EmojiStorageCache", "setNeedUpdateGroupInfo: %s", Boolean.valueOf(z));
        if (z) {
            Intent intent = new Intent();
            intent.setAction(EmojiUpdateReceiver.ACTION);
            intent.putExtra(EmojiUpdateReceiver.ezN, EmojiUpdateReceiver.ezR);
            ah.getContext().sendBroadcast(intent);
        }
        AppMethodBeat.o(62239);
    }

    public final void cd(boolean z) {
        AppMethodBeat.i(62240);
        this.eyz = true;
        if (z) {
            String str = EmojiUpdateReceiver.ezS;
            Intent intent = new Intent();
            intent.setAction(EmojiUpdateReceiver.ACTION);
            intent.putExtra(EmojiUpdateReceiver.ezN, str);
            ah.getContext().sendBroadcast(intent);
        }
        AppMethodBeat.o(62240);
    }
}
