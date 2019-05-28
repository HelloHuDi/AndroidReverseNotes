package com.tencent.p177mm.plugin.story.p536ui.p1037a;

import android.content.Intent;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p823ab.C8902b;
import com.tencent.p177mm.p842bp.C25985d;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u001c\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0015"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/GalleryHeaderAdapter;", "Lcom/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter$GalleryAvatarViewHolder;", "()V", "chatRoom", "", "getChatRoom", "()Ljava/lang/String;", "setChatRoom", "(Ljava/lang/String;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "GalleryAvatarViewHolder", "plugin-story_release"})
/* renamed from: com.tencent.mm.plugin.story.ui.a.b */
public final class C46285b extends C13814d<C22255a> {
    public String gpx;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter$GalleryAvatarViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/story/ui/adapter/GalleryAvatarAdapter;Landroid/view/View;)V", "avatarIv", "Landroid/widget/ImageView;", "getAvatarIv", "()Landroid/widget/ImageView;", "nickNameTv", "Landroid/widget/TextView;", "getNickNameTv", "()Landroid/widget/TextView;", "plugin-story_release"})
    /* renamed from: com.tencent.mm.plugin.story.ui.a.b$a */
    public final class C22255a extends C41531v {
        final ImageView eks;
        final TextView gtO;
        final /* synthetic */ C46285b sfp;

        public C22255a(C46285b c46285b, View view) {
            C25052j.m39376p(view, "itemView");
            this.sfp = c46285b;
            super(view);
            AppMethodBeat.m2504i(110092);
            View findViewById = view.findViewById(2131821183);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.id.avatar_iv)");
            this.eks = (ImageView) findViewById;
            findViewById = view.findViewById(2131823149);
            C25052j.m39375o(findViewById, "itemView.findViewById(R.id.nickname_tv)");
            this.gtO = (TextView) findViewById;
            C8902b.m16047f(this.gtO);
            AppMethodBeat.m2505o(110092);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.a.b$b */
    static final class C35233b implements OnClickListener {
        final /* synthetic */ C46285b sfp;
        final /* synthetic */ String sfq;
        final /* synthetic */ C22255a sfr;

        C35233b(C46285b c46285b, String str, C22255a c22255a) {
            this.sfp = c46285b;
            this.sfq = str;
            this.sfr = c22255a;
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(110093);
            C25052j.m39375o(view, "it");
            if (view.isSelected()) {
                Intent intent = new Intent();
                intent.putExtra("Contact_User", this.sfq);
                intent.putExtra("Contact_ChatRoomId", this.sfp.gpx);
                intent.putExtra("CONTACT_INFO_UI_SOURCE", 15);
                View view2 = this.sfr.apJ;
                C25052j.m39375o(view2, "holder.itemView");
                C25985d.m41467b(view2.getContext(), Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            }
            AppMethodBeat.m2505o(110093);
        }
    }

    public final int getItemCount() {
        AppMethodBeat.m2504i(110094);
        int size = this.iLD.size();
        AppMethodBeat.m2505o(110094);
        return size;
    }
}
