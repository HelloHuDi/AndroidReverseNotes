package com.bumptech.glide.c.a;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class n extends l<InputStream> {
    private static final UriMatcher azz;

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ void R(Object obj) {
        AppMethodBeat.i(91731);
        ((InputStream) obj).close();
        AppMethodBeat.o(91731);
    }

    static {
        AppMethodBeat.i(91733);
        UriMatcher uriMatcher = new UriMatcher(-1);
        azz = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        azz.addURI("com.android.contacts", "contacts/lookup/*", 1);
        azz.addURI("com.android.contacts", "contacts/#/photo", 2);
        azz.addURI("com.android.contacts", "contacts/#", 3);
        azz.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        azz.addURI("com.android.contacts", "phone_lookup/*", 5);
        AppMethodBeat.o(91733);
    }

    public n(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    public final Class<InputStream> mg() {
        return InputStream.class;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object a(Uri uri, ContentResolver contentResolver) {
        Object openContactPhotoInputStream;
        FileNotFoundException fileNotFoundException;
        AppMethodBeat.i(91732);
        switch (azz.match(uri)) {
            case 1:
            case 5:
                Uri lookupContact = Contacts.lookupContact(contentResolver, uri);
                if (lookupContact != null) {
                    openContactPhotoInputStream = Contacts.openContactPhotoInputStream(contentResolver, lookupContact, true);
                    break;
                }
                fileNotFoundException = new FileNotFoundException("Contact cannot be found");
                AppMethodBeat.o(91732);
                throw fileNotFoundException;
            case 3:
                openContactPhotoInputStream = Contacts.openContactPhotoInputStream(contentResolver, uri, true);
                break;
            default:
                openContactPhotoInputStream = contentResolver.openInputStream(uri);
                break;
        }
        if (openContactPhotoInputStream == null) {
            fileNotFoundException = new FileNotFoundException("InputStream is null for ".concat(String.valueOf(uri)));
            AppMethodBeat.o(91732);
            throw fileNotFoundException;
        }
        AppMethodBeat.o(91732);
        return openContactPhotoInputStream;
    }
}
