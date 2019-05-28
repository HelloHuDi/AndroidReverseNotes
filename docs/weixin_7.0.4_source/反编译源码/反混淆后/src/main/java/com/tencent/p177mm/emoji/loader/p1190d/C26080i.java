package com.tencent.p177mm.emoji.loader.p1190d;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.lang.ref.WeakReference;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u0000 \u0014*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0014B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00028\u0000¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/emoji/loader/request/ViewRequest;", "V", "Landroid/view/View;", "Lcom/tencent/mm/emoji/loader/request/Request;", "Landroid/graphics/drawable/Drawable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "view", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;Landroid/view/View;)V", "weakView", "Ljava/lang/ref/WeakReference;", "getWeakView", "()Ljava/lang/ref/WeakReference;", "setWeakView", "(Ljava/lang/ref/WeakReference;)V", "cancel", "", "onLoad", "success", "", "Companion", "plugin-emojisdk_release"})
/* renamed from: com.tencent.mm.emoji.loader.d.i */
public abstract class C26080i<V extends View> extends C18207h<Drawable> {
    private static final int eyj = 2131820596;
    public static final C26079a eyk = new C26079a();
    WeakReference<V> eyi;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/emoji/loader/request/ViewRequest$Companion;", "", "()V", "TAG_ID", "", "getTAG_ID", "()I", "plugin-emojisdk_release"})
    /* renamed from: com.tencent.mm.emoji.loader.d.i$a */
    public static final class C26079a {
        private C26079a() {
        }

        public /* synthetic */ C26079a(byte b) {
            this();
        }
    }

    public C26080i(EmojiInfo emojiInfo, V v) {
        C25052j.m39376p(emojiInfo, "emojiInfo");
        C25052j.m39376p(v, "view");
        super(emojiInfo);
        this.eyi = new WeakReference(v);
        C18207h c18207h = (C18207h) v.getTag(eyj);
        if (c18207h != null) {
            c18207h.cancel();
        }
        v.setTag(eyj, this);
    }

    /* renamed from: bX */
    public void mo33677bX(boolean z) {
        View view;
        WeakReference weakReference = this.eyi;
        if (weakReference != null) {
            view = (View) weakReference.get();
        } else {
            view = null;
        }
        if (view != null) {
            view.setTag(eyj, null);
        }
    }

    public void cancel() {
        View view;
        super.cancel();
        WeakReference weakReference = this.eyi;
        if (weakReference != null) {
            view = (View) weakReference.get();
        } else {
            view = null;
        }
        if (view != null) {
            view.setTag(eyj, null);
        }
        this.eyi = null;
    }
}
