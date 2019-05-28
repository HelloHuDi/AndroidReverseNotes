package com.facebook.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.facebook.FacebookContentProvider;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public final class NativeAppCallAttachmentStore {
    static final String ATTACHMENTS_DIR_NAME = "com.facebook.NativeAppCallAttachmentStore.files";
    private static final String TAG = NativeAppCallAttachmentStore.class.getName();
    private static File attachmentsDirectory;

    public static final class Attachment {
        private final String attachmentName;
        private final String attachmentUrl;
        private Bitmap bitmap;
        private final UUID callId;
        private boolean isContentUri;
        private Uri originalUri;
        private boolean shouldCreateFile;

        private Attachment(UUID uuid, Bitmap bitmap, Uri uri) {
            String attachmentUrl;
            boolean z = true;
            AppMethodBeat.i(72423);
            this.callId = uuid;
            this.bitmap = bitmap;
            this.originalUri = uri;
            FacebookException facebookException;
            if (uri != null) {
                String scheme = uri.getScheme();
                if (b.CONTENT.equalsIgnoreCase(scheme)) {
                    this.isContentUri = true;
                    if (uri.getAuthority() == null || uri.getAuthority().startsWith("media")) {
                        z = false;
                    }
                    this.shouldCreateFile = z;
                } else if ("file".equalsIgnoreCase(uri.getScheme())) {
                    this.shouldCreateFile = true;
                } else if (!Utility.isWebUri(uri)) {
                    facebookException = new FacebookException("Unsupported scheme for media Uri : ".concat(String.valueOf(scheme)));
                    AppMethodBeat.o(72423);
                    throw facebookException;
                }
            } else if (bitmap != null) {
                this.shouldCreateFile = true;
            } else {
                facebookException = new FacebookException("Cannot share media without a bitmap or Uri set");
                AppMethodBeat.o(72423);
                throw facebookException;
            }
            this.attachmentName = !this.shouldCreateFile ? null : UUID.randomUUID().toString();
            if (this.shouldCreateFile) {
                attachmentUrl = FacebookContentProvider.getAttachmentUrl(FacebookSdk.getApplicationId(), uuid, this.attachmentName);
            } else {
                attachmentUrl = this.originalUri.toString();
            }
            this.attachmentUrl = attachmentUrl;
            AppMethodBeat.o(72423);
        }

        public final String getAttachmentUrl() {
            return this.attachmentUrl;
        }

        public final Uri getOriginalUri() {
            return this.originalUri;
        }
    }

    static {
        AppMethodBeat.i(72436);
        AppMethodBeat.o(72436);
    }

    private NativeAppCallAttachmentStore() {
    }

    public static Attachment createAttachment(UUID uuid, Bitmap bitmap) {
        AppMethodBeat.i(72424);
        Validate.notNull(uuid, "callId");
        Validate.notNull(bitmap, "attachmentBitmap");
        Attachment attachment = new Attachment(uuid, bitmap, null);
        AppMethodBeat.o(72424);
        return attachment;
    }

    public static Attachment createAttachment(UUID uuid, Uri uri) {
        AppMethodBeat.i(72425);
        Validate.notNull(uuid, "callId");
        Validate.notNull(uri, "attachmentUri");
        Attachment attachment = new Attachment(uuid, null, uri);
        AppMethodBeat.o(72425);
        return attachment;
    }

    private static void processAttachmentBitmap(Bitmap bitmap, File file) {
        AppMethodBeat.i(72426);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            bitmap.compress(CompressFormat.JPEG, 100, fileOutputStream);
        } finally {
            Utility.closeQuietly(fileOutputStream);
            AppMethodBeat.o(72426);
        }
    }

    private static void processAttachmentFile(Uri uri, boolean z, File file) {
        InputStream openInputStream;
        AppMethodBeat.i(72427);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        if (z) {
            openInputStream = FacebookSdk.getApplicationContext().getContentResolver().openInputStream(uri);
        } else {
            try {
                openInputStream = new FileInputStream(uri.getPath());
            } catch (Throwable th) {
                Utility.closeQuietly(fileOutputStream);
                AppMethodBeat.o(72427);
            }
        }
        Utility.copyAndCloseInputStream(openInputStream, fileOutputStream);
        Utility.closeQuietly(fileOutputStream);
        AppMethodBeat.o(72427);
    }

    public static void addAttachments(Collection<Attachment> collection) {
        AppMethodBeat.i(72428);
        if (collection == null || collection.size() == 0) {
            AppMethodBeat.o(72428);
            return;
        }
        if (attachmentsDirectory == null) {
            cleanupAllAttachments();
        }
        ensureAttachmentsDirectoryExists();
        ArrayList<File> arrayList = new ArrayList();
        try {
            for (Attachment attachment : collection) {
                if (attachment.shouldCreateFile) {
                    File attachmentFile = getAttachmentFile(attachment.callId, attachment.attachmentName, true);
                    arrayList.add(attachmentFile);
                    if (attachment.bitmap != null) {
                        processAttachmentBitmap(attachment.bitmap, attachmentFile);
                    } else if (attachment.originalUri != null) {
                        processAttachmentFile(attachment.originalUri, attachment.isContentUri, attachmentFile);
                    }
                }
            }
            AppMethodBeat.o(72428);
        } catch (IOException e) {
            Throwable th = e;
            new StringBuilder("Got unexpected exception:").append(th);
            for (File delete : arrayList) {
                try {
                    delete.delete();
                } catch (Exception e2) {
                }
            }
            FacebookException facebookException = new FacebookException(th);
            AppMethodBeat.o(72428);
            throw facebookException;
        }
    }

    public static void cleanupAttachmentsForCall(UUID uuid) {
        AppMethodBeat.i(72429);
        File attachmentsDirectoryForCall = getAttachmentsDirectoryForCall(uuid, false);
        if (attachmentsDirectoryForCall != null) {
            Utility.deleteDirectory(attachmentsDirectoryForCall);
        }
        AppMethodBeat.o(72429);
    }

    public static File openAttachment(UUID uuid, String str) {
        AppMethodBeat.i(72430);
        FileNotFoundException fileNotFoundException;
        if (Utility.isNullOrEmpty(str) || uuid == null) {
            fileNotFoundException = new FileNotFoundException();
            AppMethodBeat.o(72430);
            throw fileNotFoundException;
        }
        try {
            File attachmentFile = getAttachmentFile(uuid, str, false);
            AppMethodBeat.o(72430);
            return attachmentFile;
        } catch (IOException e) {
            fileNotFoundException = new FileNotFoundException();
            AppMethodBeat.o(72430);
            throw fileNotFoundException;
        }
    }

    static synchronized File getAttachmentsDirectory() {
        File file;
        synchronized (NativeAppCallAttachmentStore.class) {
            AppMethodBeat.i(72431);
            if (attachmentsDirectory == null) {
                attachmentsDirectory = new File(FacebookSdk.getApplicationContext().getCacheDir(), ATTACHMENTS_DIR_NAME);
            }
            file = attachmentsDirectory;
            AppMethodBeat.o(72431);
        }
        return file;
    }

    static File ensureAttachmentsDirectoryExists() {
        AppMethodBeat.i(72432);
        File attachmentsDirectory = getAttachmentsDirectory();
        attachmentsDirectory.mkdirs();
        AppMethodBeat.o(72432);
        return attachmentsDirectory;
    }

    static File getAttachmentsDirectoryForCall(UUID uuid, boolean z) {
        AppMethodBeat.i(72433);
        if (attachmentsDirectory == null) {
            AppMethodBeat.o(72433);
            return null;
        }
        File file = new File(attachmentsDirectory, uuid.toString());
        if (z && !file.exists()) {
            file.mkdirs();
        }
        AppMethodBeat.o(72433);
        return file;
    }

    static File getAttachmentFile(UUID uuid, String str, boolean z) {
        AppMethodBeat.i(72434);
        File attachmentsDirectoryForCall = getAttachmentsDirectoryForCall(uuid, z);
        if (attachmentsDirectoryForCall == null) {
            AppMethodBeat.o(72434);
            return null;
        }
        try {
            File file = new File(attachmentsDirectoryForCall, URLEncoder.encode(str, "UTF-8"));
            AppMethodBeat.o(72434);
            return file;
        } catch (UnsupportedEncodingException e) {
            AppMethodBeat.o(72434);
            return null;
        }
    }

    public static void cleanupAllAttachments() {
        AppMethodBeat.i(72435);
        Utility.deleteDirectory(getAttachmentsDirectory());
        AppMethodBeat.o(72435);
    }
}
