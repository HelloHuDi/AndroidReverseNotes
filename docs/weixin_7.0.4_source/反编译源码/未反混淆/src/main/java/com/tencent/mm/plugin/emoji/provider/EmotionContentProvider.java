package com.tencent.mm.plugin.emoji.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureUploadManager.UploadTask;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.o;
import java.io.Serializable;
import java.util.ArrayList;

public class EmotionContentProvider extends ContentProvider {
    private static final UriMatcher kXi;

    static {
        AppMethodBeat.i(53170);
        UriMatcher uriMatcher = new UriMatcher(-1);
        kXi = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.storage.provider.emotion", "EmojiGroupInfo", 1);
        kXi.addURI("com.tencent.mm.storage.provider.emotion", "userinfo", 2);
        kXi.addURI("com.tencent.mm.storage.provider.emotion", "GetEmotionListCache", 3);
        kXi.addURI("com.tencent.mm.storage.provider.emotion", "EmojiInfo", 4);
        kXi.addURI("com.tencent.mm.storage.provider.emotion", "EmojiInfoDesc", 5);
        AppMethodBeat.o(53170);
    }

    public boolean onCreate() {
        AppMethodBeat.i(53164);
        ab.i("MicroMsg.EmotionContentProvider", "[onCreate]");
        AppMethodBeat.o(53164);
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        AppMethodBeat.i(53165);
        ab.i("MicroMsg.EmotionContentProvider", "[query] path:%s selection:%s", uri.getPath(), str);
        Cursor a;
        switch (kXi.match(uri)) {
            case 1:
                a = g.RP().eJN.a(str, strArr2, 2);
                AppMethodBeat.o(53165);
                return a;
            case 3:
                a = g.RP().eJN.a(str, strArr2, 2);
                AppMethodBeat.o(53165);
                return a;
            case 4:
                a = g.RP().eJN.a(str, strArr2, 2);
                AppMethodBeat.o(53165);
                return a;
            case 5:
                a = g.RP().eJN.a(str, strArr2, 2);
                AppMethodBeat.o(53165);
                return a;
            default:
                AppMethodBeat.o(53165);
                return null;
        }
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        AppMethodBeat.i(53166);
        switch (kXi.match(uri)) {
            case 3:
                uri = Uri.withAppendedPath(uri, String.valueOf(g.RP().eJN.insert("GetEmotionListCache", o.ccO.xDc, contentValues)));
                AppMethodBeat.o(53166);
                return uri;
            default:
                AppMethodBeat.o(53166);
                return uri;
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        AppMethodBeat.i(53167);
        switch (kXi.match(uri)) {
            case 3:
                int delete = g.RP().eJN.delete("GetEmotionListCache", str, strArr);
                AppMethodBeat.o(53167);
                return delete;
            default:
                AppMethodBeat.o(53167);
                return 0;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        AppMethodBeat.i(53168);
        if (g.RN().QY()) {
            switch (kXi.match(uri)) {
                case 1:
                    int update = g.RP().eJN.update("EmojiGroupInfo", contentValues, str, strArr);
                    AppMethodBeat.o(53168);
                    return update;
                case 2:
                    g.RP().Ry().set(((Integer) contentValues.get("type")).intValue(), contentValues.get("value"));
                    AppMethodBeat.o(53168);
                    return 0;
                default:
                    AppMethodBeat.o(53168);
                    return -1;
            }
        }
        AppMethodBeat.o(53168);
        return -1;
    }

    public Bundle call(String str, String str2, Bundle bundle) {
        boolean z = true;
        boolean z2 = false;
        AppMethodBeat.i(53169);
        ab.d("MicroMsg.EmotionContentProvider", "[call] method:%s", str);
        Bundle bundle2;
        Bundle bundle3;
        if (str.equals("getAccPath")) {
            bundle2 = new Bundle();
            bundle2.putString("path", g.RP().eJM);
            AppMethodBeat.o(53169);
            return bundle2;
        } else if (str.equals("getEmojiKey")) {
            bundle2 = new Bundle();
            bundle2.putString("key", j.getEmojiStorageMgr().xYn.getKey());
            AppMethodBeat.o(53169);
            return bundle2;
        } else if (str.equals("ConfigStorage.getBoolean")) {
            bundle3 = new Bundle();
            bundle3.putBoolean("key", ((Boolean) g.RP().Ry().get(bundle.getInt("key"), Boolean.FALSE)).booleanValue());
            AppMethodBeat.o(53169);
            return bundle3;
        } else if (str.equals("ConfigStorage.getString")) {
            bundle3 = new Bundle();
            bundle3.putString("key", (String) g.RP().Ry().get(bundle.getInt("key"), (Object) ""));
            AppMethodBeat.o(53169);
            return bundle3;
        } else if (str.equals("getAllCustomEmoji")) {
            bundle2 = new Bundle(EmojiInfo.class.getClassLoader());
            bundle2.putParcelableArrayList("data", j.getEmojiStorageMgr().bY(false));
            AppMethodBeat.o(53169);
            return bundle2;
        } else {
            Bundle bundle4;
            String str3;
            if (str.equals("getRandomEmoji")) {
                if (bundle != null) {
                    bundle.setClassLoader(EmojiInfo.class.getClassLoader());
                    EmojiInfo emojiInfo = (EmojiInfo) bundle.getParcelable("emoji");
                    bundle4 = new Bundle(EmojiInfo.class.getClassLoader());
                    bundle4.putParcelable("data", ((d) g.M(d.class)).getEmojiMgr().n(emojiInfo));
                    AppMethodBeat.o(53169);
                    return bundle4;
                }
                str3 = "MicroMsg.EmotionContentProvider";
                String str4 = "[getRandomEmoji] extras:%s";
                Object[] objArr = new Object[1];
                if (bundle != null) {
                    z = false;
                }
                objArr[0] = Boolean.valueOf(z);
                ab.e(str3, str4, objArr);
            } else if (str.equals("getCurLangDesc")) {
                bundle2 = new Bundle();
                bundle2.putString("data", j.getEmojiDescMgr().Jh(str2));
                AppMethodBeat.o(53169);
                return bundle2;
            } else if (str.equals("countCustomEmoji")) {
                if (bundle != null) {
                    z = bundle.getBoolean("withSystem");
                    z2 = bundle.getBoolean("onlySuccess");
                }
                bundle4 = new Bundle();
                bundle4.putInt("data", j.getEmojiStorageMgr().xYn.y(z, z2));
                AppMethodBeat.o(53169);
                return bundle4;
            } else if (str.equals("countCaptureEmoji")) {
                if (bundle != null) {
                    z = bundle.getBoolean("onlySuccess");
                }
                bundle3 = new Bundle();
                bundle3.putInt("data", j.getEmojiStorageMgr().xYn.pr(z));
                AppMethodBeat.o(53169);
                return bundle3;
            } else if (str.equals("countProductId")) {
                bundle2 = new Bundle();
                bundle2.putInt("data", j.getEmojiStorageMgr().xYn.Jp(str2));
                AppMethodBeat.o(53169);
                return bundle2;
            } else if (str.equals("getDownloadedCount")) {
                bundle2 = new Bundle();
                bundle2.putInt("data", j.getEmojiStorageMgr().bjV());
                AppMethodBeat.o(53169);
                return bundle2;
            } else if (str.equals("getEmojiListByGroupId")) {
                bundle3 = new Bundle(EmojiInfo.class.getClassLoader());
                bundle3.putParcelableArrayList("data", (ArrayList) ((d) g.M(d.class)).getEmojiMgr().Jg(str2));
                AppMethodBeat.o(53169);
                return bundle3;
            } else if (str.equals("getEmojiGroupInfoList")) {
                bundle2 = new Bundle(EmojiGroupInfo.class.getClassLoader());
                bundle2.putParcelableArrayList("data", j.getEmojiStorageMgr().xYz.OD());
                AppMethodBeat.o(53169);
                return bundle2;
            } else if (str.equals("createEmojiInfo")) {
                if (bundle != null) {
                    EmojiInfo j = ((d) g.M(d.class)).getEmojiMgr().j(bundle.getString("key_md5"), bundle.getInt("key_group"), bundle.getInt("key_type"), bundle.getInt("key_size"));
                    bundle2 = new Bundle();
                    bundle2.putParcelable("key_emoji_info", j);
                    AppMethodBeat.o(53169);
                    return bundle2;
                }
            } else if (str.equals("updateEmojiInfo")) {
                if (bundle != null) {
                    bundle.setClassLoader(EmojiInfo.class.getClassLoader());
                    ((d) g.M(d.class)).getEmojiMgr().updateEmojiInfo((EmojiInfo) bundle.get("key_emoji_info"));
                }
            } else if (str.equals("isEnableHEVCDecode")) {
                bundle3 = new Bundle();
                bundle3.putBoolean("key_data", ((d) g.M(d.class)).getEmojiMgr().bjX());
                AppMethodBeat.o(53169);
                return bundle3;
            } else if (str.equals("isEnableHevcUpload")) {
                bundle3 = new Bundle();
                bundle3.putBoolean("key_data", ((d) g.M(d.class)).getEmojiMgr().OS());
                AppMethodBeat.o(53169);
                return bundle3;
            } else if (str.equals("getEmojiByMd5")) {
                if (bundle != null) {
                    str3 = bundle.getString("key_md5");
                    bundle3 = new Bundle();
                    bundle3.putParcelable("key_emoji_info", ((d) g.M(d.class)).getEmojiMgr().Je(str3));
                    AppMethodBeat.o(53169);
                    return bundle3;
                }
            } else if (str.equals("getConfig")) {
                if (bundle != null) {
                    Object c = ((d) g.M(d.class)).getEmojiMgr().c((a) bundle.get("key_config_key"), null);
                    bundle3 = new Bundle();
                    bundle3.putSerializable("key_config_value", (Serializable) c);
                    AppMethodBeat.o(53169);
                    return bundle3;
                }
            } else if (str.equals("setConfig")) {
                if (bundle != null) {
                    ((d) g.M(d.class)).getEmojiMgr().d((a) bundle.get("key_config_key"), bundle.get("key_config_value"));
                }
            } else if (str.equals("checkGifFile")) {
                if (bundle != null) {
                    bundle3 = new Bundle();
                    bundle3.putBoolean("key_data", ((d) g.M(d.class)).getEmojiMgr().Jq(bundle.getString("key_path")));
                    AppMethodBeat.o(53169);
                    return bundle3;
                }
            } else if (str.equals("getSmileyInfoList")) {
                bundle4 = new Bundle();
                try {
                    bundle4.putParcelableArrayList("key_data", ((d) g.M(d.class)).getEmojiMgr().bjO());
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.EmotionContentProvider", e, "", new Object[0]);
                }
                AppMethodBeat.o(53169);
                return bundle4;
            } else if (str.equals("deleteLoadingCaptureEmoji")) {
                if (!bo.isNullOrNil(str2)) {
                    ((d) g.M(d.class)).getEmojiMgr().Jr(str2);
                }
            } else if (str.equals("uploadEmojiRemote")) {
                if (bundle != null) {
                    String str5 = (String) bundle.getParcelable("emojiMd5");
                    bundle.setClassLoader(EmojiCaptureReporter.class.getClassLoader());
                    ((d) g.M(d.class)).getEmojiMgr().a(new UploadTask(str5, (EmojiCaptureReporter) bundle.getParcelable("reporter")));
                }
            } else if (str.equals("showCaptureEmojiInPanel")) {
                if (bundle != null) {
                    bundle.setClassLoader(EmojiInfo.class.getClassLoader());
                    ((d) g.M(d.class)).getEmojiMgr().q((EmojiInfo) bundle.getParcelable("emojiInfo"));
                }
            } else if (str.equals("showCaptureEmojiDefaultErrorDialog")) {
                if (bundle != null) {
                    bundle.setClassLoader(EmojiInfo.class.getClassLoader());
                    ((d) g.M(d.class)).getEmojiMgr().r((EmojiInfo) bundle.getParcelable("emojiInfo"));
                }
            } else if (str.equals("addCaptureEmojiUploadTask")) {
                if (bundle != null) {
                    bundle.setClassLoader(UploadTask.class.getClassLoader());
                    ((d) g.M(d.class)).getEmojiMgr().b((UploadTask) bundle.getParcelable("uploadTask"));
                }
            } else if (str.equals("getCaptureEmoji")) {
                bundle2 = new Bundle();
                bundle2.putParcelableArrayList("key_data", com.tencent.mm.emoji.a.a.OB().bZ(false));
                AppMethodBeat.o(53169);
                return bundle2;
            }
            AppMethodBeat.o(53169);
            return null;
        }
    }
}
