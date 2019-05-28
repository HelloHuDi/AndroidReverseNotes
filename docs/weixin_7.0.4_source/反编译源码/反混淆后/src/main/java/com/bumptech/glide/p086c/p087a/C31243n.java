package com.bumptech.glide.p086c.p087a;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* renamed from: com.bumptech.glide.c.a.n */
public final class C31243n extends C25404l<InputStream> {
    private static final UriMatcher azz;

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: R */
    public final /* synthetic */ void mo42446R(Object obj) {
        AppMethodBeat.m2504i(91731);
        ((InputStream) obj).close();
        AppMethodBeat.m2505o(91731);
    }

    static {
        AppMethodBeat.m2504i(91733);
        UriMatcher uriMatcher = new UriMatcher(-1);
        azz = uriMatcher;
        uriMatcher.addURI("com.android.contacts", "contacts/lookup/*/#", 1);
        azz.addURI("com.android.contacts", "contacts/lookup/*", 1);
        azz.addURI("com.android.contacts", "contacts/#/photo", 2);
        azz.addURI("com.android.contacts", "contacts/#", 3);
        azz.addURI("com.android.contacts", "contacts/#/display_photo", 4);
        azz.addURI("com.android.contacts", "phone_lookup/*", 5);
        AppMethodBeat.m2505o(91733);
    }

    public C31243n(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    /* renamed from: mg */
    public final Class<InputStream> mo2187mg() {
        return InputStream.class;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    /* renamed from: a */
    public final /* synthetic */ Object mo42447a(Uri uri, ContentResolver contentResolver) {
        Object openContactPhotoInputStream;
        FileNotFoundException fileNotFoundException;
        AppMethodBeat.m2504i(91732);
        switch (azz.match(uri)) {
            case 1:
            case 5:
                Uri lookupContact = Contacts.lookupContact(contentResolver, uri);
                if (lookupContact != null) {
                    openContactPhotoInputStream = Contacts.openContactPhotoInputStream(contentResolver, lookupContact, true);
                    break;
                }
                fileNotFoundException = new FileNotFoundException("Contact cannot be found");
                AppMethodBeat.m2505o(91732);
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
            AppMethodBeat.m2505o(91732);
            throw fileNotFoundException;
        }
        AppMethodBeat.m2505o(91732);
        return openContactPhotoInputStream;
    }
}
