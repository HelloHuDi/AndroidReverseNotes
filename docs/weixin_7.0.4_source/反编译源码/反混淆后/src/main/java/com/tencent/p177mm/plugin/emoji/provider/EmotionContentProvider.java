package com.tencent.p177mm.plugin.emoji.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.emoji.p227a.C32497a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.emoji.model.C42952j;
import com.tencent.p177mm.plugin.emoji.p725b.C6835d;
import com.tencent.p177mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.p177mm.plugin.emojicapture.api.EmojiCaptureUploadManager.UploadTask;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.storage.emotion.C30305o;
import com.tencent.p177mm.storage.emotion.EmojiGroupInfo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.io.Serializable;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.plugin.emoji.provider.EmotionContentProvider */
public class EmotionContentProvider extends ContentProvider {
    private static final UriMatcher kXi;

    static {
        AppMethodBeat.m2504i(53170);
        UriMatcher uriMatcher = new UriMatcher(-1);
        kXi = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.storage.provider.emotion", "EmojiGroupInfo", 1);
        kXi.addURI("com.tencent.mm.storage.provider.emotion", "userinfo", 2);
        kXi.addURI("com.tencent.mm.storage.provider.emotion", "GetEmotionListCache", 3);
        kXi.addURI("com.tencent.mm.storage.provider.emotion", "EmojiInfo", 4);
        kXi.addURI("com.tencent.mm.storage.provider.emotion", "EmojiInfoDesc", 5);
        AppMethodBeat.m2505o(53170);
    }

    public boolean onCreate() {
        AppMethodBeat.m2504i(53164);
        C4990ab.m7416i("MicroMsg.EmotionContentProvider", "[onCreate]");
        AppMethodBeat.m2505o(53164);
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.m2504i(53165);
        C4990ab.m7417i("MicroMsg.EmotionContentProvider", "[query] path:%s selection:%s", uri.getPath(), str);
        Cursor a;
        switch (kXi.match(uri)) {
            case 1:
                a = C1720g.m3536RP().eJN.mo10104a(str, strArr2, 2);
                AppMethodBeat.m2505o(53165);
                return a;
            case 3:
                a = C1720g.m3536RP().eJN.mo10104a(str, strArr2, 2);
                AppMethodBeat.m2505o(53165);
                return a;
            case 4:
                a = C1720g.m3536RP().eJN.mo10104a(str, strArr2, 2);
                AppMethodBeat.m2505o(53165);
                return a;
            case 5:
                a = C1720g.m3536RP().eJN.mo10104a(str, strArr2, 2);
                AppMethodBeat.m2505o(53165);
                return a;
            default:
                AppMethodBeat.m2505o(53165);
                return null;
        }
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        AppMethodBeat.m2504i(53166);
        switch (kXi.match(uri)) {
            case 3:
                uri = Uri.withAppendedPath(uri, String.valueOf(C1720g.m3536RP().eJN.insert("GetEmotionListCache", C30305o.ccO.xDc, contentValues)));
                AppMethodBeat.m2505o(53166);
                return uri;
            default:
                AppMethodBeat.m2505o(53166);
                return uri;
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        AppMethodBeat.m2504i(53167);
        switch (kXi.match(uri)) {
            case 3:
                int delete = C1720g.m3536RP().eJN.delete("GetEmotionListCache", str, strArr);
                AppMethodBeat.m2505o(53167);
                return delete;
            default:
                AppMethodBeat.m2505o(53167);
                return 0;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        AppMethodBeat.m2504i(53168);
        if (C1720g.m3534RN().mo5161QY()) {
            switch (kXi.match(uri)) {
                case 1:
                    int update = C1720g.m3536RP().eJN.update("EmojiGroupInfo", contentValues, str, strArr);
                    AppMethodBeat.m2505o(53168);
                    return update;
                case 2:
                    C1720g.m3536RP().mo5239Ry().set(((Integer) contentValues.get("type")).intValue(), contentValues.get("value"));
                    AppMethodBeat.m2505o(53168);
                    return 0;
                default:
                    AppMethodBeat.m2505o(53168);
                    return -1;
            }
        }
        AppMethodBeat.m2505o(53168);
        return -1;
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.m2504i(53169);
        C4990ab.m7411d("MicroMsg.EmotionContentProvider", "[call] method:%s", str);
        Bundle bundle2;
        Bundle bundle3;
        if (str.equals("getAccPath")) {
            bundle2 = new Bundle();
            bundle2.putString("path", C1720g.m3536RP().eJM);
            AppMethodBeat.m2505o(53169);
            return bundle2;
        } else if (str.equals("getEmojiKey")) {
            bundle2 = new Bundle();
            bundle2.putString("key", C42952j.getEmojiStorageMgr().xYn.getKey());
            AppMethodBeat.m2505o(53169);
            return bundle2;
        } else if (str.equals("ConfigStorage.getBoolean")) {
            bundle3 = new Bundle();
            bundle3.putBoolean("key", ((Boolean) C1720g.m3536RP().mo5239Ry().get(bundle.getInt("key"), Boolean.FALSE)).booleanValue());
            AppMethodBeat.m2505o(53169);
            return bundle3;
        } else if (str.equals("ConfigStorage.getString")) {
            bundle3 = new Bundle();
            bundle3.putString("key", (String) C1720g.m3536RP().mo5239Ry().get(bundle.getInt("key"), (Object) ""));
            AppMethodBeat.m2505o(53169);
            return bundle3;
        } else if (str.equals("getAllCustomEmoji")) {
            bundle2 = new Bundle(EmojiInfo.class.getClassLoader());
            bundle2.putParcelableArrayList("data", C42952j.getEmojiStorageMgr().mo39170bY(false));
            AppMethodBeat.m2505o(53169);
            return bundle2;
        } else {
            Bundle bundle4;
            String str3;
            if (str.equals("getRandomEmoji")) {
                if (bundle != null) {
                    bundle.setClassLoader(EmojiInfo.class.getClassLoader());
                    EmojiInfo emojiInfo = (EmojiInfo) bundle.getParcelable("emoji");
                    bundle4 = new Bundle(EmojiInfo.class.getClassLoader());
                    bundle4.putParcelable("data", ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35657n(emojiInfo));
                    AppMethodBeat.m2505o(53169);
                    return bundle4;
                }
                str3 = "MicroMsg.EmotionContentProvider";
                String str4 = "[getRandomEmoji] extras:%s";
                Object[] objArr = new Object[1];
                if (bundle != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                C4990ab.m7413e(str3, str4, objArr);
            } else if (str.equals("getCurLangDesc")) {
                bundle2 = new Bundle();
                bundle2.putString("data", C42952j.getEmojiDescMgr().mo69856Jh(str2));
                AppMethodBeat.m2505o(53169);
                return bundle2;
            } else if (str.equals("countCustomEmoji")) {
                if (bundle != null) {
                    z = bundle.getBoolean("withSystem");
                    z2 = bundle.getBoolean("onlySuccess");
                }
                bundle4 = new Bundle();
                bundle4.putInt("data", C42952j.getEmojiStorageMgr().xYn.mo48592y(z, z2));
                AppMethodBeat.m2505o(53169);
                return bundle4;
            } else if (str.equals("countCaptureEmoji")) {
                if (bundle != null) {
                    z = bundle.getBoolean("onlySuccess");
                }
                bundle3 = new Bundle();
                bundle3.putInt("data", C42952j.getEmojiStorageMgr().xYn.mo48589pr(z));
                AppMethodBeat.m2505o(53169);
                return bundle3;
            } else if (str.equals("countProductId")) {
                bundle2 = new Bundle();
                bundle2.putInt("data", C42952j.getEmojiStorageMgr().xYn.mo48558Jp(str2));
                AppMethodBeat.m2505o(53169);
                return bundle2;
            } else if (str.equals("getDownloadedCount")) {
                bundle2 = new Bundle();
                bundle2.putInt("data", C42952j.getEmojiStorageMgr().bjV());
                AppMethodBeat.m2505o(53169);
                return bundle2;
            } else if (str.equals("getEmojiListByGroupId")) {
                bundle3 = new Bundle(EmojiInfo.class.getClassLoader());
                bundle3.putParcelableArrayList("data", (ArrayList) ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35599Jg(str2));
                AppMethodBeat.m2505o(53169);
                return bundle3;
            } else if (str.equals("getEmojiGroupInfoList")) {
                bundle2 = new Bundle(EmojiGroupInfo.class.getClassLoader());
                bundle2.putParcelableArrayList("data", C42952j.getEmojiStorageMgr().xYz.mo53135OD());
                AppMethodBeat.m2505o(53169);
                return bundle2;
            } else if (str.equals("createEmojiInfo")) {
                if (bundle != null) {
                    EmojiInfo j = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35651j(bundle.getString("key_md5"), bundle.getInt("key_group"), bundle.getInt("key_type"), bundle.getInt("key_size"));
                    bundle2 = new Bundle();
                    bundle2.putParcelable("key_emoji_info", j);
                    AppMethodBeat.m2505o(53169);
                    return bundle2;
                }
            } else if (str.equals("updateEmojiInfo")) {
                if (bundle != null) {
                    bundle.setClassLoader(EmojiInfo.class.getClassLoader());
                    ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().updateEmojiInfo((EmojiInfo) bundle.get("key_emoji_info"));
                }
            } else if (str.equals("isEnableHEVCDecode")) {
                bundle3 = new Bundle();
                bundle3.putBoolean("key_data", ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().bjX());
                AppMethodBeat.m2505o(53169);
                return bundle3;
            } else if (str.equals("isEnableHevcUpload")) {
                bundle3 = new Bundle();
                bundle3.putBoolean("key_data", ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35613OS());
                AppMethodBeat.m2505o(53169);
                return bundle3;
            } else if (str.equals("getEmojiByMd5")) {
                if (bundle != null) {
                    str3 = bundle.getString("key_md5");
                    bundle3 = new Bundle();
                    bundle3.putParcelable("key_emoji_info", ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35597Je(str3));
                    AppMethodBeat.m2505o(53169);
                    return bundle3;
                }
            } else if (str.equals("getConfig")) {
                if (bundle != null) {
                    Object c = ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35641c((C5127a) bundle.get("key_config_key"), null);
                    bundle3 = new Bundle();
                    bundle3.putSerializable("key_config_value", (Serializable) c);
                    AppMethodBeat.m2505o(53169);
                    return bundle3;
                }
            } else if (str.equals("setConfig")) {
                if (bundle != null) {
                    ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35644d((C5127a) bundle.get("key_config_key"), bundle.get("key_config_value"));
                }
            } else if (str.equals("checkGifFile")) {
                if (bundle != null) {
                    bundle3 = new Bundle();
                    bundle3.putBoolean("key_data", ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35609Jq(bundle.getString("key_path")));
                    AppMethodBeat.m2505o(53169);
                    return bundle3;
                }
            } else if (str.equals("getSmileyInfoList")) {
                bundle4 = new Bundle();
                try {
                    bundle4.putParcelableArrayList("key_data", ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().bjO());
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.EmotionContentProvider", e, "", new Object[0]);
                }
                AppMethodBeat.m2505o(53169);
                return bundle4;
            } else if (str.equals("deleteLoadingCaptureEmoji")) {
                if (!C5046bo.isNullOrNil(str2)) {
                    ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35610Jr(str2);
                }
            } else if (str.equals("uploadEmojiRemote")) {
                if (bundle != null) {
                    String str5 = (String) bundle.getParcelable("emojiMd5");
                    bundle.setClassLoader(EmojiCaptureReporter.class.getClassLoader());
                    ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35618a(new UploadTask(str5, (EmojiCaptureReporter) bundle.getParcelable("reporter")));
                }
            } else if (str.equals("showCaptureEmojiInPanel")) {
                if (bundle != null) {
                    bundle.setClassLoader(EmojiInfo.class.getClassLoader());
                    ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35661q((EmojiInfo) bundle.getParcelable("emojiInfo"));
                }
            } else if (str.equals("showCaptureEmojiDefaultErrorDialog")) {
                if (bundle != null) {
                    bundle.setClassLoader(EmojiInfo.class.getClassLoader());
                    ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35662r((EmojiInfo) bundle.getParcelable("emojiInfo"));
                }
            } else if (str.equals("addCaptureEmojiUploadTask")) {
                if (bundle != null) {
                    bundle.setClassLoader(UploadTask.class.getClassLoader());
                    ((C6835d) C1720g.m3530M(C6835d.class)).getEmojiMgr().mo35624b((UploadTask) bundle.getParcelable("uploadTask"));
                }
            } else if (str.equals("getCaptureEmoji")) {
                bundle2 = new Bundle();
                bundle2.putParcelableArrayList("key_data", C32497a.m53203OB().mo53137bZ(false));
                AppMethodBeat.m2505o(53169);
                return bundle2;
            }
            AppMethodBeat.m2505o(53169);
            return null;
        }
    }
}
