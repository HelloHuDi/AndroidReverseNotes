package com.tencent.mm.pluginsdk.ui.e;

import android.text.SpannableString;

public interface d {

    public static class a {
        protected static d vrE;

        public static final void a(d dVar) {
            vrE = dVar;
        }
    }

    boolean G(CharSequence charSequence);

    boolean H(CharSequence charSequence);

    SpannableString o(CharSequence charSequence, int i);
}
