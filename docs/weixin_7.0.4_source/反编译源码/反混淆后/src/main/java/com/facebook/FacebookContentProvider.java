package com.facebook;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import com.facebook.internal.NativeAppCallAttachmentStore;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.UUID;

public class FacebookContentProvider extends ContentProvider {
    private static final String ATTACHMENT_URL_BASE = "content://com.facebook.app.FacebookContentProvider";
    private static final String INVALID_FILE_NAME = "..";
    private static final String TAG = FacebookContentProvider.class.getName();

    static {
        AppMethodBeat.m2504i(71578);
        AppMethodBeat.m2505o(71578);
    }

    public static String getAttachmentUrl(String str, UUID uuid, String str2) {
        AppMethodBeat.m2504i(71575);
        String format = String.format("%s%s/%s/%s", new Object[]{ATTACHMENT_URL_BASE, str, uuid.toString(), str2});
        AppMethodBeat.m2505o(71575);
        return format;
    }

    public boolean onCreate() {
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }

    public ParcelFileDescriptor openFile(Uri uri, String str) {
        AppMethodBeat.m2504i(71576);
        Pair parseCallIdAndAttachmentName = parseCallIdAndAttachmentName(uri);
        FileNotFoundException fileNotFoundException;
        if (parseCallIdAndAttachmentName == null) {
            fileNotFoundException = new FileNotFoundException();
            AppMethodBeat.m2505o(71576);
            throw fileNotFoundException;
        }
        try {
            File openAttachment = NativeAppCallAttachmentStore.openAttachment((UUID) parseCallIdAndAttachmentName.first, (String) parseCallIdAndAttachmentName.second);
            if (openAttachment == null) {
                fileNotFoundException = new FileNotFoundException();
                AppMethodBeat.m2505o(71576);
                throw fileNotFoundException;
            }
            ParcelFileDescriptor open = ParcelFileDescriptor.open(openAttachment, 268435456);
            AppMethodBeat.m2505o(71576);
            return open;
        } catch (FileNotFoundException fileNotFoundException2) {
            new StringBuilder("Got unexpected exception:").append(fileNotFoundException2);
            AppMethodBeat.m2505o(71576);
            throw fileNotFoundException2;
        }
    }

    /* Access modifiers changed, original: 0000 */
    public Pair<UUID, String> parseCallIdAndAttachmentName(Uri uri) {
        AppMethodBeat.m2504i(71577);
        try {
            String[] split = uri.getPath().substring(1).split("/");
            CharSequence charSequence = split[0];
            CharSequence charSequence2 = split[1];
            if (INVALID_FILE_NAME.contentEquals(charSequence) || INVALID_FILE_NAME.contentEquals(charSequence2)) {
                Exception exception = new Exception();
                AppMethodBeat.m2505o(71577);
                throw exception;
            }
            Pair<UUID, String> pair = new Pair(UUID.fromString(charSequence), charSequence2);
            AppMethodBeat.m2505o(71577);
            return pair;
        } catch (Exception e) {
            AppMethodBeat.m2505o(71577);
            return null;
        }
    }
}
