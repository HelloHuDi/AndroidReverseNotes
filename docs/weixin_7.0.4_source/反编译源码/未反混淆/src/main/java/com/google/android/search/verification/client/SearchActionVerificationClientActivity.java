package com.google.android.search.verification.client;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class SearchActionVerificationClientActivity extends Activity {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public abstract Class<? extends SearchActionVerificationClientService> up();

    /* Access modifiers changed, original: protected|final */
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = new Intent(this, up());
        intent.putExtra("SearchActionVerificationClientExtraIntent", getIntent());
        startService(intent);
        finish();
    }
}
