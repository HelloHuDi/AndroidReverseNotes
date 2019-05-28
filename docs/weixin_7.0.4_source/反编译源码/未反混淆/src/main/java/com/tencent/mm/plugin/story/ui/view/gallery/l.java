package com.tencent.mm.plugin.story.ui.view.gallery;

import a.f.a.q;
import a.v;
import a.y;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.an;
import android.text.SpannableString;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs.CastExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.ar;
import com.tencent.mm.g.b.a.au;
import com.tencent.mm.model.cb;
import com.tencent.mm.plugin.story.api.AbsStoryGallery;
import com.tencent.mm.plugin.story.ui.album.StoryFavAlbumUI;
import com.tencent.mm.plugin.story.ui.view.StoryCommentView;
import com.tencent.mm.protocal.protobuf.cee;
import com.tencent.mm.protocal.protobuf.cek;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.az;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.listview.PullDownListView;
import java.util.ArrayList;
import java.util.List;

@a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u000b*\u0002(P\u0018\u0000 ²\u00012\u00020\u0001:\u0004²\u0001³\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010o\u001a\u00020pH\u0002J\b\u0010q\u001a\u00020pH\u0002J\u0012\u0010r\u001a\u00020p2\b\u0010s\u001a\u0004\u0018\u00010tH\u0016J\u0010\u0010u\u001a\u00020\t2\u0006\u0010v\u001a\u00020\u0007H\u0016J\u001a\u0010w\u001a\u00020p2\b\b\u0002\u0010x\u001a\u00020\u00072\b\b\u0002\u0010y\u001a\u00020\u0007J\b\u0010z\u001a\u00020pH\u0016J\b\u0010{\u001a\u00020\u0007H\u0002J\u0010\u0010|\u001a\u00020\t2\u0006\u0010}\u001a\u00020~H\u0016J\b\u0010\u001a\u00020pH\u0002J\t\u0010\u0001\u001a\u00020pH\u0002J\t\u0010\u0001\u001a\u00020\tH\u0002J\t\u0010\u0001\u001a\u00020\tH\u0016J\u0012\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0001\u001a\u00020pH\u0002J\t\u0010\u0001\u001a\u00020pH\u0016J\u001d\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020\u00072\t\u0010\u0001\u001a\u0004\u0018\u00010GH\u0002J\u0012\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020\u0007H\u0016J\u0012\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0001\u001a\u00020pH\u0016J\t\u0010\u0001\u001a\u00020pH\u0016J\t\u0010\u0001\u001a\u00020pH\u0016J\t\u0010\u0001\u001a\u00020pH\u0016J(\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020\u00072\t\u0010\u0001\u001a\u0004\u0018\u0001052\t\u0010\u0001\u001a\u0004\u0018\u00010LH\u0002J\t\u0010\u0001\u001a\u00020pH\u0002J\t\u0010\u0001\u001a\u00020pH\u0002J\t\u0010\u0001\u001a\u00020pH\u0016J\t\u0010\u0001\u001a\u00020pH\u0016J\u0012\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020\tH\u0016J#\u0010\u0001\u001a\u00020p2\u0006\u0010?\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\t2\u0007\u0010\u0001\u001a\u00020\tH\u0016J\u0010\u0010\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020\u0007J\t\u0010\u0001\u001a\u00020pH\u0002J\u0013\u0010\u0001\u001a\u00020p2\b\u0010 \u0001\u001a\u00030¡\u0001H\u0002J\u0007\u0010¢\u0001\u001a\u00020pJ\u0010\u0010£\u0001\u001a\u00020p2\u0007\u0010¤\u0001\u001a\u00020\tJ\u0012\u0010¥\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020\u0007H\u0016J\u0012\u0010¦\u0001\u001a\u00020p2\u0007\u0010\u0001\u001a\u00020\u0007H\u0016J\u0015\u0010§\u0001\u001a\u00020p2\n\u0010¨\u0001\u001a\u0005\u0018\u00010©\u0001H\u0002J\u0015\u0010ª\u0001\u001a\u00020p2\n\u0010¨\u0001\u001a\u0005\u0018\u00010©\u0001H\u0016J\u0007\u0010«\u0001\u001a\u00020pJ\u0010\u0010¬\u0001\u001a\u00020p2\u0007\u0010­\u0001\u001a\u00020/J\u0014\u0010®\u0001\u001a\u00020p2\t\u0010­\u0001\u001a\u0004\u0018\u00010\u000fH\u0016J\t\u0010¯\u0001\u001a\u00020pH\u0016J\u0012\u0010°\u0001\u001a\u00020p2\u0007\u0010±\u0001\u001a\u00020\tH\u0002R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0010\u0010'\u001a\u00020(X\u0004¢\u0006\u0004\n\u0002\u0010)R>\u0010*\u001a2\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020,0+j\b\u0012\u0004\u0012\u00020,`-0+j\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020,0+j\b\u0012\u0004\u0012\u00020,`-`-X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0010\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0004¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010;\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u001f\"\u0004\b<\u0010!R\u001a\u0010=\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001f\"\u0004\b>\u0010!R\u000e\u0010?\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001f\"\u0004\bA\u0010!R\u000e\u0010B\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020GX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u0004\u0018\u00010LX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020NX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u00020PX\u0004¢\u0006\u0004\n\u0002\u0010QR\u0010\u0010R\u001a\u0004\u0018\u00010SX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020UX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010GX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020XX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010Y\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010[\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0015\"\u0004\b]\u0010\u0017R\u0010\u0010^\u001a\u0004\u0018\u00010_X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020aX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010b\u001a\u00060cR\u00020aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020gX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020iX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010j\u001a\u0004\u0018\u00010kX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010l\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\u001f\"\u0004\bn\u0010!¨\u0006´\u0001"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView;", "Lcom/tencent/mm/plugin/story/api/AbsStoryGallery;", "context", "Landroid/content/Context;", "galleryType", "Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "expectPos", "", "needAction", "", "(Landroid/content/Context;Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;IZ)V", "activePanel", "addReadNumRunnable", "Ljava/lang/Runnable;", "browseUIListener", "Lcom/tencent/mm/plugin/story/api/IStoryBrowseUIListener;", "canDragScale", "value", "", "chatRoom", "getChatRoom", "()Ljava/lang/String;", "setChatRoom", "(Ljava/lang/String;)V", "clickListener", "Lkotlin/Function0;", "commentScrolling", "currentItemView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryItemView;", "deleteWhenFirstEmpty", "getDeleteWhenFirstEmpty", "()Z", "setDeleteWhenFirstEmpty", "(Z)V", "dirty", "dragCloseConsumer", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDragCloseConsumer;", "getExpectPos", "()I", "galleryGroupUpdateCallback", "com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$galleryGroupUpdateCallback$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$galleryGroupUpdateCallback$1;", "galleryGroups", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "Lkotlin/collections/ArrayList;", "galleryScaleListener", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "galleryScrollHelper", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollHelper;", "getGalleryType", "()Lcom/tencent/mm/plugin/story/api/IStoryUIFactory$GalleryType;", "hRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "hasDispatchCancel", "holderView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHolderView;", "horizontalAdapter", "Lcom/tencent/mm/plugin/story/ui/adapter/StoryGalleryAdapter;", "isFirstPost", "setFirstPost", "isForSns", "setForSns", "isMute", "isNeedReset", "setNeedReset", "isSelf", "jumpItemReport", "lastSelectColumn", "mIsActive", "maskView", "Landroid/view/View;", "menuDialog", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDeleteDialog;", "needCancelTouch", "pageIndicator", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "pageSnapHelper", "Landroid/support/v7/widget/PagerSnapHelper;", "postListener", "com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$postListener$1", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$postListener$1;", "presenter", "Lcom/tencent/mm/plugin/story/presenter/IGalleryPresenter;", "pullDownHint", "Landroid/widget/TextView;", "pullDownListView", "scrollUpHintCheck", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryScrollUpCheck;", "selectedColumn", "selectedRow", "sessionId", "getSessionId", "setSessionId", "tipDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "vRecyclerView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView;", "verticalAdapter", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryRecyclerView$VerticalAdapter;", "verticalControlView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryVerticalControlView;", "verticalPageSnapHelper", "Lcom/tencent/mm/plugin/story/ui/view/gallery/PageScrollHelper;", "verticalScrollOffset", "", "videoViewMgr", "Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryVideoViewMgr;", "videoViewMgrFromPreLoad", "getVideoViewMgrFromPreLoad", "setVideoViewMgrFromPreLoad", "addListeners", "", "addVideoReadNumber", "bindPullDownListView", "wrapperView", "Lcom/tencent/mm/ui/widget/listview/PullDownListView;", "canScrollHorizontally", "direction", "checkDoPreloadBeforeEnterGallery", "verticalIndex", "horizontalIndex", "checkUpdate", "contentScrollType", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "fadeInMaskView", "fadeOutMaskView", "needVerticalControl", "onBackPressed", "onClosing", "offset", "onDeleteStory", "onDestroy", "onItemSelected", "position", "childView", "onListInnerScroll", "onOpening", "onPause", "onPreImageMode", "onPreVideoMode", "onResume", "onRowSelected", "row", "rowView", "horizontalControlView", "onSetFavoriteStory", "onSetPrivacy", "onStart", "onStop", "onSwitchImageMode", "enableReport", "onSwitchVideoMode", "fromPreCache", "remixItem", "mediaLocalId", "removeListeners", "resendItem", "storyVideoItem", "Lcom/tencent/mm/plugin/story/model/gallery/StoryVideoItem;", "reset", "setCanDragScale", "canScale", "setCurrentHItem", "setCurrentVItem", "setDataInternal", "dataSeed", "", "setDataSeed", "setFilterList", "setGalleryScaleListener", "listener", "setStoryBrowseUIListener", "showPullDownHint", "toggleActiveState", "newActive", "Companion", "IOnGalleryScale", "plugin-story_release"})
public final class l extends AbsStoryGallery {
    private static final String TAG = TAG;
    public static final a spJ = new a();
    private String cvF;
    private boolean czr;
    private boolean dirty;
    private boolean eif;
    private String gpx;
    private View iVh;
    private final int rZE;
    private boolean rZI;
    private int rZb;
    private f shf;
    private boolean shh;
    private boolean shi;
    private boolean shj;
    private final a.f.a.a<Boolean> skn;
    final com.tencent.mm.plugin.story.api.m.a soE;
    private p soY;
    private b soz;
    private final g spA;
    private boolean spB;
    private final g spC;
    private int spD;
    private boolean spE;
    private boolean spF;
    private boolean spG;
    private final m spH;
    private Runnable spI;
    private boolean spd;
    private boolean spe;
    private View spf;
    final TextView spg;
    private StoryGalleryItemView sph;
    private RecyclerView spi;
    private GalleryHorizontalControlView spj;
    private com.tencent.mm.plugin.story.ui.a.g spk;
    private final an spl;
    private final j spm;
    private int spn;
    private float spo;
    private final GalleryRecyclerView spq;
    private final ArrayList<ArrayList<com.tencent.mm.plugin.story.model.d.g>> spr;
    private com.tencent.mm.plugin.story.f.h sps;
    private boolean spt;
    private com.tencent.mm.plugin.story.api.g spu;
    private boolean spv;
    private c spw;
    private final GalleryVerticalControlView spx;
    private a spy;
    private final GalleryHolderView spz;
    private final com.tencent.mm.plugin.story.ui.view.gallery.GalleryRecyclerView.b tBv;
    private com.tencent.mm.ui.base.p tipDialog;

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\n"}, dWq = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$postListener$1", "Lcom/tencent/mm/plugin/story/api/IStoryPostListener;", "onPostEnd", "", "localId", "", "isOk", "", "onPostNotify", "onPostStart", "plugin-story_release"})
    public static final class m implements com.tencent.mm.plugin.story.api.j {
        final /* synthetic */ l spK;

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ int rXD;
            final /* synthetic */ m spS;

            a(m mVar, int i) {
                this.spS = mVar;
                this.rXD = i;
            }

            public final void run() {
                AppMethodBeat.i(110813);
                com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
                a.f.b.j.o(RP, "MMKernel.storage()");
                boolean z = RP.Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_STORY_POST_FIRST_TO_AUTOPLAY_BOOLEAN_SYNC, true);
                a aVar = l.spJ;
                ab.i(l.TAG, "onPostStart " + this.rXD + " and ret " + z);
                if (z) {
                    this.spS.spK.setFirstPost(true);
                    this.spS.spK.K(true, false);
                }
                AppMethodBeat.o(110813);
            }
        }

        m(l lVar) {
            this.spK = lVar;
        }

        public final void cwX() {
            AppMethodBeat.i(110814);
            if (this.spK.czr) {
                com.tencent.mm.plugin.story.f.h l = this.spK.sps;
                if (l != null) {
                    l.czC();
                    AppMethodBeat.o(110814);
                    return;
                }
            }
            AppMethodBeat.o(110814);
        }

        public final void EI(int i) {
            AppMethodBeat.i(110815);
            a aVar = l.spJ;
            ab.i(l.TAG, "onPostStart ".concat(String.valueOf(i)));
            if (this.spK.czr) {
                if (this.spK.spt) {
                    this.spK.setNeedReset(true);
                    AppMethodBeat.o(110815);
                    return;
                }
                com.tencent.mm.plugin.story.f.h l = this.spK.sps;
                if (l != null) {
                    l.czC();
                }
                if (this.spK.spr.size() == 1 && ((ArrayList) this.spK.spr.get(0)).size() > 0) {
                    this.spK.setCurrentHItem(0);
                }
                if (this.spK.spr.size() == 1 && ((ArrayList) this.spK.spr.get(0)).size() == 1) {
                    al.d(new a(this, i));
                }
            }
            AppMethodBeat.o(110815);
        }

        public final void cwW() {
            AppMethodBeat.i(110816);
            com.tencent.mm.plugin.story.model.i.a aVar = com.tencent.mm.plugin.story.model.i.rSv;
            com.tencent.mm.sdk.g.d.post(com.tencent.mm.plugin.story.model.i.a.b.rSx, "Story_cleanAudioFile");
            if (this.spK.czr) {
                if (this.spK.spt) {
                    this.spK.setNeedReset(true);
                    AppMethodBeat.o(110816);
                    return;
                }
                com.tencent.mm.plugin.story.f.h l = this.spK.sps;
                if (l != null) {
                    l.czC();
                    AppMethodBeat.o(110816);
                    return;
                }
            }
            AppMethodBeat.o(110816);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class n implements Runnable {
        final /* synthetic */ int exi;
        final /* synthetic */ l spK;

        n(l lVar, int i) {
            this.spK = lVar;
            this.exi = i;
        }

        public final void run() {
            AppMethodBeat.i(110817);
            a aVar = l.spJ;
            ab.d(l.TAG, "setCurrentHItem=" + this.spK.rZb + " galleryGroups.size=" + this.spK.spr.size() + " galleryGroups[selectedRow].size=" + ((ArrayList) this.spK.spr.get(this.spK.rZb)).size() + " hRecyclerView=" + this.spK.spi);
            RecyclerView i = this.spK.spi;
            if (i != null) {
                i.bY(this.exi);
                AppMethodBeat.o(110817);
                return;
            }
            AppMethodBeat.o(110817);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$IOnGalleryScale;", "", "onBgAlpha", "", "alpha", "", "onGalleryExitFromTop", "plugin-story_release"})
    public interface b {
        void bc(float f);

        void cCg();
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$fadeInMaskView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationStart", "", "p0", "Landroid/animation/Animator;", "plugin-story_release"})
    public static final class e extends AnimatorListenerAdapter {
        final /* synthetic */ l spK;

        e(l lVar) {
            this.spK = lVar;
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.i(110789);
            this.spK.iVh.setVisibility(0);
            AppMethodBeat.o(110789);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    static final class k implements OnClickListener {
        final /* synthetic */ l spK;

        k(l lVar) {
            this.spK = lVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(138951);
            com.tencent.mm.plugin.story.f.h l = this.spK.sps;
            if (l != null) {
                boolean z;
                int g = this.spK.rZb;
                int m = this.spK.spn;
                a o = this.spK.spy;
                if (o != null) {
                    z = o.rYr;
                } else {
                    z = false;
                }
                l.o(g, m, z);
                AppMethodBeat.o(138951);
                return;
            }
            AppMethodBeat.o(138951);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    static final class l implements OnClickListener {
        final /* synthetic */ l spK;

        l(l lVar) {
            this.spK = lVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            AppMethodBeat.i(110812);
            com.tencent.mm.plugin.story.f.h l = this.spK.sps;
            if (l != null) {
                boolean z;
                int g = this.spK.rZb;
                int m = this.spK.spn;
                a o = this.spK.spy;
                if (o != null) {
                    z = o.rvv;
                } else {
                    z = false;
                }
                l.n(g, m, z);
                AppMethodBeat.o(110812);
                return;
            }
            AppMethodBeat.o(110812);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$2 */
    static final class AnonymousClass2 implements View.OnClickListener {
        final /* synthetic */ l spK;

        AnonymousClass2(l lVar) {
            this.spK = lVar;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(138942);
            if (this.spK.spr.size() == 1 && ((ArrayList) this.spK.spr.get(0)).isEmpty()) {
                com.tencent.mm.plugin.story.api.g p = this.spK.spu;
                if (p != null) {
                    p.caC();
                    AppMethodBeat.o(138942);
                    return;
                }
            }
            AppMethodBeat.o(138942);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class d implements Runnable {
        final /* synthetic */ l spK;

        d(l lVar) {
            this.spK = lVar;
        }

        public final void run() {
            AppMethodBeat.i(110788);
            StoryGalleryItemView A = this.spK.sph;
            if (A == null || A.getVideoItem() == null) {
                AppMethodBeat.o(110788);
                return;
            }
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.h.k cxT = com.tencent.mm.plugin.story.model.j.a.cxT();
            StoryGalleryItemView A2 = this.spK.sph;
            if (A2 == null) {
                a.f.b.j.dWJ();
            }
            com.tencent.mm.plugin.story.model.d.i videoItem = A2.getVideoItem();
            if (videoItem == null) {
                a.f.b.j.dWJ();
            }
            int b = com.tencent.mm.plugin.story.h.k.b(cxT, videoItem.rUJ);
            a aVar2 = l.spJ;
            String access$getTAG$cp = l.TAG;
            StringBuilder stringBuilder = new StringBuilder("storyId :");
            StoryGalleryItemView A3 = this.spK.sph;
            if (A3 == null) {
                a.f.b.j.dWJ();
            }
            com.tencent.mm.plugin.story.model.d.i videoItem2 = A3.getVideoItem();
            if (videoItem2 == null) {
                a.f.b.j.dWJ();
            }
            ab.i(access$getTAG$cp, stringBuilder.append(videoItem2.rUJ).append(" read times + 1  ,result:").append(b).toString());
            AppMethodBeat.o(110788);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, dWq = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$fadeOutMaskView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "p0", "Landroid/animation/Animator;", "plugin-story_release"})
    public static final class f extends AnimatorListenerAdapter {
        final /* synthetic */ l spK;

        f(l lVar) {
            this.spK = lVar;
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.i(110790);
            this.spK.iVh.setVisibility(8);
            AppMethodBeat.o(110790);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    static final class c extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ l spK;

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$c$1 */
        static final class AnonymousClass1 extends a.f.b.k implements a.f.a.a<y> {
            final /* synthetic */ c spN;

            AnonymousClass1(c cVar) {
                this.spN = cVar;
                super(0);
            }

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(110786);
                com.tencent.mm.plugin.story.f.h l = this.spN.spK.sps;
                if (l != null) {
                    l.czC();
                }
                y yVar = y.AUy;
                AppMethodBeat.o(110786);
                return yVar;
            }
        }

        c(l lVar) {
            this.spK = lVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(110787);
            a aVar = l.spJ;
            ab.i(l.TAG, "is receive a message to update");
            if (this.spK.czr) {
                if (this.spK.spt) {
                    aVar = l.spJ;
                    ab.i(l.TAG, "is receive a message to update but is was not allow ");
                    this.spK.setNeedReset(true);
                } else {
                    aVar = l.spJ;
                    ab.i(l.TAG, "is receive a message to update and do it  ");
                    com.tencent.mm.ab.b.a(new AnonymousClass1(this));
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(110787);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
    static final class o implements Runnable {
        final /* synthetic */ int exi;
        final /* synthetic */ l spK;

        o(l lVar, int i) {
            this.spK = lVar;
            this.exi = i;
        }

        public final void run() {
            AppMethodBeat.i(110818);
            this.spK.spq.bY(this.exi);
            AppMethodBeat.o(110818);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\bH\u0016J\u001e\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u0019"}, dWq = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$galleryGroupUpdateCallback$1", "Lcom/tencent/mm/plugin/story/presenter/GalleryGroupUpdateCallback;", "deleteGroup", "", "groupIndex", "", "notifyDeleteResult", "isOk", "", "notifyGroup", "notifyIndicator", "notifyItemsChange", "start", "count", "notifyItemsInsert", "notifyItemsRemove", "notifySetFavResult", "favorite", "notifySetPrivacyResult", "isPrivacy", "updateGroup", "items", "", "Lcom/tencent/mm/plugin/story/model/gallery/StoryGalleryItem;", "updateGroupCount", "plugin-story_release"})
    public static final class g implements com.tencent.mm.plugin.story.f.e {
        final /* synthetic */ Context jWS;
        final /* synthetic */ l spK;

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        static final class b implements Runnable {
            final /* synthetic */ g spO;
            final /* synthetic */ int spP;

            b(g gVar, int i) {
                this.spO = gVar;
                this.spP = i;
            }

            public final void run() {
                AppMethodBeat.i(110792);
                this.spO.spK.tBv.cg(this.spP);
                AppMethodBeat.o(110792);
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        static final class c implements Runnable {
            final /* synthetic */ g spO;
            final /* synthetic */ int spP;

            c(g gVar, int i) {
                this.spO = gVar;
                this.spP = i;
            }

            public final void run() {
                AppMethodBeat.i(110793);
                this.spO.spK.tBv.cg(this.spP);
                AppMethodBeat.o(110793);
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        static final class e implements Runnable {
            final /* synthetic */ g spO;

            e(g gVar) {
                this.spO = gVar;
            }

            public final void run() {
                AppMethodBeat.i(110795);
                l lVar = this.spO.spK;
                com.tencent.mm.storage.ac.a aVar = null;
                if (lVar.soE == com.tencent.mm.plugin.story.api.m.a.ProfileGallery) {
                    aVar = com.tencent.mm.storage.ac.a.USERINFO_STORY_PULL_DOWN_PROFILE_FIRST_BOOLEAN_SYNC;
                }
                if (aVar != null) {
                    com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
                    a.f.b.j.o(RP, "storage()");
                    if (!RP.Ry().getBoolean(aVar, false)) {
                        LayoutParams layoutParams = lVar.spg.getLayoutParams();
                        if (layoutParams == null) {
                            v vVar = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                            AppMethodBeat.o(110795);
                            throw vVar;
                        }
                        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) layoutParams;
                        ak.hF(lVar.getContext());
                        marginLayoutParams.topMargin = -lVar.getTop();
                        lVar.spg.setLayoutParams(marginLayoutParams);
                        lVar.spg.setVisibility(0);
                        TextView textView = lVar.spg;
                        String string = lVar.getResources().getString(R.string.etc);
                        a.f.b.j.o(string, "resources.getString(R.string.story_pull_hint)");
                        textView.setText(a.l(string, lVar.spg.getCurrentTextColor()));
                    }
                }
                AppMethodBeat.o(110795);
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ g spO;
            final /* synthetic */ int spP;

            a(g gVar, int i) {
                this.spO = gVar;
                this.spP = i;
            }

            public final void run() {
                AppMethodBeat.i(110791);
                this.spO.spK.tBv.cg(this.spP);
                AppMethodBeat.o(110791);
            }
        }

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "run"})
        static final class d implements Runnable {
            final /* synthetic */ g spO;
            final /* synthetic */ int spP;

            d(g gVar, int i) {
                this.spO = gVar;
                this.spP = i;
            }

            public final void run() {
                AppMethodBeat.i(110794);
                this.spO.spK.tBv.cg(this.spP);
                AppMethodBeat.o(110794);
            }
        }

        g(l lVar, Context context) {
            this.spK = lVar;
            this.jWS = context;
        }

        public final void lB(boolean z) {
            AppMethodBeat.i(110796);
            this.spK.spx.lU(z);
            AppMethodBeat.o(110796);
        }

        public final void lA(boolean z) {
            AppMethodBeat.i(110797);
            this.spK.spx.lT(z);
            AppMethodBeat.o(110797);
        }

        public final void lz(boolean z) {
            AppMethodBeat.i(110798);
            com.tencent.mm.ui.base.p n = this.spK.tipDialog;
            if (n != null) {
                n.dismiss();
            }
            if (z) {
                com.tencent.mm.plugin.story.model.d dVar = com.tencent.mm.plugin.story.model.d.rSg;
                com.tencent.mm.plugin.story.model.d.cxB();
                AppMethodBeat.o(110798);
                return;
            }
            t.makeText(this.jWS, this.jWS.getResources().getString(R.string.esg), 0).show();
            AppMethodBeat.o(110798);
        }

        public final void EP(int i) {
            AppMethodBeat.i(110799);
            if (i <= 1) {
                this.spK.spA.cCG();
            }
            this.spK.spr.clear();
            for (int i2 = 0; i2 < i; i2++) {
                this.spK.spr.add(new ArrayList());
            }
            AppMethodBeat.o(110799);
        }

        public final void j(int i, List<com.tencent.mm.plugin.story.model.d.g> list) {
            AppMethodBeat.i(110800);
            a.f.b.j.p(list, "items");
            a aVar = l.spJ;
            ab.c(l.TAG, "updateGroup, groupIndex:" + i + ", items:" + list.size() + ", active:" + this.spK.spt + ", galleryType:" + this.spK.getGalleryType(), new Object[0]);
            if (i >= this.spK.spr.size()) {
                AppMethodBeat.o(110800);
                return;
            }
            ((ArrayList) this.spK.spr.get(i)).clear();
            ((ArrayList) this.spK.spr.get(i)).addAll(list);
            this.spK.tBv.dI(this.spK.spr);
            if (this.spK.rZb == i) {
                com.tencent.mm.plugin.story.ui.a.g x = this.spK.spk;
                if (x != null) {
                    x.dI(list);
                }
            }
            com.tencent.mm.plugin.story.api.g p;
            if (this.spK.spr.size() == 1 && list.isEmpty()) {
                p = this.spK.spu;
                if (p != null) {
                    p.caA();
                }
                this.spK.iVh.setVisibility(8);
                if (this.spK.getGalleryType() == com.tencent.mm.plugin.story.api.m.a.SelfTabGallery) {
                    this.spK.spz.setVisibility(0);
                    com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
                    com.tencent.mm.plugin.story.g.h.cAw().bE(1);
                    hVar = com.tencent.mm.plugin.story.g.h.scu;
                    com.tencent.mm.plugin.story.g.h.cAx();
                } else {
                    this.spK.spz.setVisibility(8);
                }
            } else {
                this.spK.post(new e(this));
                p = this.spK.spu;
                if (p != null) {
                    p.caB();
                }
                this.spK.spz.setVisibility(8);
                if (!this.spK.spt) {
                    this.spK.iVh.setAlpha(1.0f);
                    this.spK.iVh.setVisibility(0);
                }
            }
            if (i != 0 || this.spK.spt || this.spK.getGalleryType() == com.tencent.mm.plugin.story.api.m.a.HistoryGallery || this.spK.getGalleryType() == com.tencent.mm.plugin.story.api.m.a.MultiUserGallery) {
                if (i == 1) {
                    this.spK.getGalleryType();
                    com.tencent.mm.plugin.story.api.m.a aVar2 = com.tencent.mm.plugin.story.api.m.a.MultiUserGallery;
                }
                AppMethodBeat.o(110800);
                return;
            }
            this.spK.Fk(0);
            AppMethodBeat.o(110800);
        }

        public final void EQ(int i) {
            AppMethodBeat.i(110801);
            a aVar = l.spJ;
            ab.i(l.TAG, "deleteGroup: exitCheck " + this.spK.getDeleteWhenFirstEmpty() + ' ' + i + ' ' + this.spK.rZb);
            int i2 = (this.spK.getDeleteWhenFirstEmpty() && i == 0 && this.spK.rZb <= 0) ? 1 : 0;
            com.tencent.mm.plugin.story.api.g p;
            if (i2 != 0) {
                p = this.spK.spu;
                if (p != null) {
                    p.caC();
                    AppMethodBeat.o(110801);
                    return;
                }
                AppMethodBeat.o(110801);
                return;
            }
            i2 = this.spK.spr.size();
            if (i >= 0 && i2 > i) {
                this.spK.spr.remove(i);
                this.spK.tBv.dI(this.spK.spr);
                this.spK.tBv.ci(i);
                com.tencent.mm.plugin.story.ui.a.d dVar = this.spK.spx.soF;
                if (dVar != null && i >= 0 && i < dVar.iLD.size() - 2) {
                    dVar.iLD.remove(i + 1);
                    dVar.ci(i + 1);
                }
            }
            if (this.spK.spr.size() <= 1) {
                this.spK.spA.cCG();
            }
            if (this.spK.spr.isEmpty()) {
                p = this.spK.spu;
                if (p != null) {
                    p.caA();
                }
                this.spK.iVh.setVisibility(8);
                AppMethodBeat.o(110801);
                return;
            }
            p = this.spK.spu;
            if (p != null) {
                p.caB();
            }
            if (!this.spK.spt) {
                this.spK.iVh.setAlpha(1.0f);
                this.spK.iVh.setVisibility(0);
            }
            AppMethodBeat.o(110801);
        }

        public final void ER(int i) {
            AppMethodBeat.i(110802);
            a aVar = l.spJ;
            ab.c(l.TAG, "notifyGroup, groupIndex:" + i + ", selectedRow:" + this.spK.rZb, new Object[0]);
            if (this.spK.rZb == i) {
                com.tencent.mm.plugin.story.ui.a.g x = this.spK.spk;
                if (x != null) {
                    x.notifyDataSetChanged();
                    AppMethodBeat.o(110802);
                    return;
                }
                AppMethodBeat.o(110802);
                return;
            }
            this.spK.spq.post(new a(this, i));
            AppMethodBeat.o(110802);
        }

        public final void ai(int i, int i2, int i3) {
            AppMethodBeat.i(110803);
            if (this.spK.rZb == i) {
                com.tencent.mm.plugin.story.ui.a.g x = this.spK.spk;
                if (x != null) {
                    x.at(i2, i3);
                    AppMethodBeat.o(110803);
                    return;
                }
                AppMethodBeat.o(110803);
                return;
            }
            this.spK.spq.post(new c(this, i));
            AppMethodBeat.o(110803);
        }

        public final void aj(int i, int i2, int i3) {
            AppMethodBeat.i(110804);
            if (this.spK.rZb == i) {
                com.tencent.mm.plugin.story.ui.a.g x = this.spK.spk;
                if (x != null) {
                    x.au(i2, i3);
                    AppMethodBeat.o(110804);
                    return;
                }
                AppMethodBeat.o(110804);
                return;
            }
            this.spK.spq.post(new d(this, i));
            AppMethodBeat.o(110804);
        }

        public final void ak(int i, int i2, int i3) {
            AppMethodBeat.i(110805);
            if (this.spK.rZb == i) {
                com.tencent.mm.plugin.story.ui.a.g x = this.spK.spk;
                if (x != null) {
                    x.ar(i2, i3);
                    AppMethodBeat.o(110805);
                    return;
                }
                AppMethodBeat.o(110805);
                return;
            }
            this.spK.spq.post(new b(this, i));
            AppMethodBeat.o(110805);
        }

        public final void czD() {
            AppMethodBeat.i(110806);
            int size = this.spK.spr.size();
            int g = this.spK.rZb;
            if (g < 0) {
                AppMethodBeat.o(110806);
                return;
            }
            if (size > g) {
                GalleryHorizontalControlView z = this.spK.spj;
                if (z != null) {
                    Object obj = this.spK.spr.get(this.spK.rZb);
                    a.f.b.j.o(obj, "galleryGroups[selectedRow]");
                    z.dI((List) obj);
                    AppMethodBeat.o(110806);
                    return;
                }
            }
            AppMethodBeat.o(110806);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    static final class i extends a.f.b.k implements a.f.a.b<Integer, y> {
        final /* synthetic */ l spK;

        i(l lVar) {
            this.spK = lVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.i(110809);
            int intValue = ((Number) obj).intValue();
            this.spK.shh = intValue == 3;
            GalleryRecyclerView d = this.spK.spq;
            if (this.spK.shh) {
                z = false;
            } else {
                z = true;
            }
            d.setScrollEnable(z);
            l lVar = this.spK;
            if (intValue == 1) {
                z = true;
            } else {
                z = false;
            }
            lVar.shi = z;
            al.af(this.spK.shf.oBn);
            f e = this.spK.shf;
            if (this.spK.shh) {
                z2 = false;
            }
            e.sof = z2;
            y yVar = y.AUy;
            AppMethodBeat.o(110809);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\n¢\u0006\u0002\b\b"}, dWq = {"<anonymous>", "", "row", "", "rowView", "Landroid/support/v7/widget/RecyclerView;", "indicatorView", "Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryHorizontalControlView;", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$3 */
    static final class AnonymousClass3 extends a.f.b.k implements q<Integer, RecyclerView, GalleryHorizontalControlView, y> {
        final /* synthetic */ l spK;

        AnonymousClass3(l lVar) {
            this.spK = lVar;
            super(3);
        }

        public final /* synthetic */ Object g(Object obj, Object obj2, Object obj3) {
            AppMethodBeat.i(138943);
            l.a(this.spK, ((Number) obj).intValue(), (RecyclerView) obj2, (GalleryHorizontalControlView) obj3);
            y yVar = y.AUy;
            AppMethodBeat.o(138943);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "position", "", "offset", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$4 */
    static final class AnonymousClass4 extends a.f.b.k implements a.f.a.m<Integer, Float, y> {
        final /* synthetic */ l spK;

        AnonymousClass4(l lVar) {
            this.spK = lVar;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(138944);
            int intValue = ((Number) obj).intValue();
            float floatValue = ((Number) obj2).floatValue();
            this.spK.spo = ((float) intValue) + floatValue;
            GalleryVerticalControlView q = this.spK.spx;
            int i = intValue + 1;
            floatValue = 1.0f - floatValue;
            if (q.soE == com.tencent.mm.plugin.story.api.m.a.MultiUserGallery) {
                intValue = com.tencent.mm.bz.a.fromDPToPix(q.getContext(), 52);
            } else {
                intValue = com.tencent.mm.bz.a.fromDPToPix(q.getContext(), 32);
            }
            com.tencent.mm.plugin.story.ui.b.a aVar = q.soG;
            if (aVar != null) {
                aVar.ah(i, (int) (((float) intValue) * floatValue));
            }
            y yVar = y.AUy;
            AppMethodBeat.o(138944);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "position", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$5 */
    static final class AnonymousClass5 extends a.f.b.k implements a.f.a.b<Integer, y> {
        final /* synthetic */ l spK;

        AnonymousClass5(l lVar) {
            this.spK = lVar;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(138945);
            int intValue = ((Number) obj).intValue();
            com.tencent.mm.plugin.story.f.h l = this.spK.sps;
            if (l != null) {
                l.ES(intValue);
            }
            y yVar = y.AUy;
            AppMethodBeat.o(138945);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$6 */
    static final class AnonymousClass6 extends a.f.b.k implements a.f.a.a<y> {
        final /* synthetic */ l spK;

        AnonymousClass6(l lVar) {
            this.spK = lVar;
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(110782);
            if (this.spK.soz != null) {
                com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
                com.tencent.mm.plugin.story.g.h.EX(12);
                b r = this.spK.soz;
                if (r != null) {
                    r.cCg();
                }
            } else {
                com.tencent.mm.plugin.story.api.g p = this.spK.spu;
                if (p != null) {
                    p.caC();
                }
            }
            y yVar = y.AUy;
            AppMethodBeat.o(110782);
            return yVar;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J.\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0016\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\n0\fj\b\u0012\u0004\u0012\u00020\n`\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u0010"}, dWq = {"com/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$setDataSeed$1", "Lcom/tencent/mm/plugin/story/api/IStoryStateFetcher$ChatRoomStateListener;", "updateChatRoomState", "", "hasStory", "", "hasUnread", "updateGalleryUserList", "userList", "", "", "unreadList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "updateUserState", "username", "plugin-story_release"})
    public static final class p implements com.tencent.mm.plugin.story.api.k.a {
        final /* synthetic */ l spK;
        final /* synthetic */ com.tencent.mm.plugin.story.model.f.d spT;

        p(l lVar, com.tencent.mm.plugin.story.model.f.d dVar) {
            this.spK = lVar;
            this.spT = dVar;
        }

        public final void a(List<String> list, ArrayList<String> arrayList) {
            AppMethodBeat.i(110819);
            a.f.b.j.p(list, "userList");
            a.f.b.j.p(arrayList, "unreadList");
            a aVar = l.spJ;
            ab.i(l.TAG, "updateGalleryUserList: " + list.size());
            l.a(this.spK, (Object) list);
            com.tencent.mm.plugin.story.g.b bVar = com.tencent.mm.plugin.story.g.b.sbw;
            com.tencent.mm.plugin.story.g.b.dF(list);
            this.spT.destroy();
            AppMethodBeat.o(110819);
        }

        public final void L(boolean z, boolean z2) {
        }

        public final void bs(String str, boolean z) {
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, dWq = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/StoryGalleryView$Companion;", "", "()V", "ClickCountShowHint", "", "TAG", "", "getTAG", "()Ljava/lang/String;", "getPullDownSpan", "Landroid/text/SpannableString;", "text", "", "color", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        public static SpannableString l(CharSequence charSequence, int i) {
            AppMethodBeat.i(110784);
            a.f.b.j.p(charSequence, "text");
            Context context = ah.getContext();
            Drawable f = com.tencent.mm.ui.ah.f(context, R.raw.story_downward_arrow, i);
            f.setBounds(0, 0, com.tencent.mm.bz.a.fromDPToPix(context, 14), com.tencent.mm.bz.a.fromDPToPix(context, 20));
            com.tencent.mm.ui.widget.a aVar = new com.tencent.mm.ui.widget.a(f);
            SpannableString spannableString = new SpannableString("#" + charSequence);
            spannableString.setSpan(aVar, 0, 1, 17);
            AppMethodBeat.o(110784);
            return spannableString;
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005H\n¢\u0006\u0002\b\u0007"}, dWq = {"<anonymous>", "", "bOk", "", "<anonymous parameter 1>", "", "kotlin.jvm.PlatformType", "onDialogClick"})
    static final class h implements com.tencent.mm.ui.widget.a.e.c {
        final /* synthetic */ l spK;
        final /* synthetic */ com.tencent.mm.plugin.story.h.j spQ;

        @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, dWq = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
        /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$h$1 */
        static final class AnonymousClass1 implements OnCancelListener {
            final /* synthetic */ h spR;

            AnonymousClass1(h hVar) {
                this.spR = hVar;
            }

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(110807);
                a aVar = l.spJ;
                ab.i(l.TAG, "delete click and click cancel it " + this.spR.spK.rZb + ' ' + this.spR.spK.spn);
                com.tencent.mm.plugin.story.f.h l = this.spR.spK.sps;
                if (l != null) {
                    this.spR.spK.rZb;
                    this.spR.spK.spn;
                    l.czB();
                    AppMethodBeat.o(110807);
                    return;
                }
                AppMethodBeat.o(110807);
            }
        }

        h(l lVar, com.tencent.mm.plugin.story.h.j jVar) {
            this.spK = lVar;
            this.spQ = jVar;
        }

        public final void d(boolean z, String str) {
            boolean z2 = false;
            AppMethodBeat.i(110808);
            a aVar = l.spJ;
            ab.i(l.TAG, "delete click and click ok it " + this.spK.rZb + ' ' + this.spK.spn);
            if (z) {
                com.tencent.mm.plugin.story.h.j jVar = this.spQ;
                if (jVar != null) {
                    if (!(jVar.field_storyID != 0)) {
                        jVar = null;
                    }
                    if (jVar != null) {
                        z2 = true;
                    }
                }
                l lVar = this.spK;
                Context context = this.spK.getContext();
                this.spK.getContext().getString(R.string.tz);
                lVar.tipDialog = com.tencent.mm.ui.base.h.b(context, this.spK.getContext().getString(R.string.esi), z2, (OnCancelListener) new AnonymousClass1(this));
                com.tencent.mm.plugin.story.f.h l = this.spK.sps;
                if (l != null) {
                    l.fM(this.spK.rZb, this.spK.spn);
                    AppMethodBeat.o(110808);
                    return;
                }
            }
            AppMethodBeat.o(110808);
        }
    }

    @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, dWq = {"<anonymous>", "", "position", "", "child", "Landroid/view/View;", "invoke"})
    static final class j extends a.f.b.k implements a.f.a.m<Integer, View, y> {
        final /* synthetic */ l spK;

        j(l lVar) {
            this.spK = lVar;
            super(2);
        }

        public final /* synthetic */ Object m(Object obj, Object obj2) {
            AppMethodBeat.i(110810);
            int intValue = ((Number) obj).intValue();
            View view = (View) obj2;
            a.f.b.j.p(view, "child");
            l.a(this.spK, intValue, view);
            y yVar = y.AUy;
            AppMethodBeat.o(110810);
            return yVar;
        }
    }

    public /* synthetic */ l(Context context, com.tencent.mm.plugin.story.api.m.a aVar) {
        this(context, aVar, 0, false);
    }

    public final int getExpectPos() {
        return this.rZE;
    }

    public final com.tencent.mm.plugin.story.api.m.a getGalleryType() {
        return this.soE;
    }

    public l(final Context context, com.tencent.mm.plugin.story.api.m.a aVar, int i, boolean z) {
        a.f.b.j.p(context, "context");
        a.f.b.j.p(aVar, "galleryType");
        super(context);
        AppMethodBeat.i(138953);
        this.soE = aVar;
        this.rZE = i;
        this.spm = new j();
        this.rZb = -1;
        this.spn = -1;
        this.dirty = true;
        this.spr = new ArrayList();
        this.spB = true;
        ab.i(TAG, " StoryGalleryView " + this.soE);
        q qVar = q.srv;
        p cDg = q.cDg();
        if (cDg == null) {
            this.soY = new p();
            this.spd = false;
        } else {
            this.spd = true;
            this.soY = cDg;
        }
        qVar = q.srv;
        q.clean();
        this.spl = new j();
        this.shf = new f(context);
        View.inflate(context, R.layout.ayp, this);
        View findViewById = findViewById(R.id.ett);
        a.f.b.j.o(findViewById, "findViewById(R.id.story_gallery_recycler)");
        this.spq = (GalleryRecyclerView) findViewById;
        findViewById = findViewById(R.id.etu);
        a.f.b.j.o(findViewById, "findViewById(R.id.story_gallery_mask_view)");
        this.iVh = findViewById;
        findViewById = findViewById(R.id.etx);
        a.f.b.j.o(findViewById, "findViewById(R.id.story_gallery_holder_layout)");
        this.spz = (GalleryHolderView) findViewById;
        findViewById = findViewById(R.id.etw);
        a.f.b.j.o(findViewById, "findViewById(R.id.story_gallery_control_layout)");
        this.spx = (GalleryVerticalControlView) findViewById;
        GalleryVerticalControlView.a(this.spx, this.soE);
        LayoutParams layoutParams = this.spx.getLayoutParams();
        if (layoutParams == null) {
            v vVar = new v("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(138953);
            throw vVar;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        int i2 = layoutParams2.topMargin;
        if (ae.hD(context)) {
            i2 += ae.hC(context);
        }
        layoutParams2.setMargins(0, i2, 0, 0);
        this.spx.setLayoutParams(layoutParams2);
        findViewById = findViewById(R.id.etv);
        a.f.b.j.o(findViewById, "findViewById(R.id.story_pull_hint)");
        this.spg = (TextView) findViewById;
        this.spx.setOnAllFav(new a.f.a.a<y>(this) {
            final /* synthetic */ l spK;

            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(138941);
                int size = this.spK.spr.size();
                int g = this.spK.rZb;
                if (g >= 0 && size > g) {
                    size = ((ArrayList) this.spK.spr.get(this.spK.rZb)).size();
                    g = this.spK.spn;
                    if (g >= 0 && size > g) {
                        Intent intent = new Intent(context, StoryFavAlbumUI.class);
                        Object obj = ((ArrayList) this.spK.spr.get(this.spK.rZb)).get(this.spK.spn);
                        a.f.b.j.o(obj, "galleryGroups[selectedRow][selectedColumn]");
                        intent.putExtra("username", ((com.tencent.mm.plugin.story.model.d.g) obj).userName);
                        context.startActivity(intent);
                    }
                }
                y yVar = y.AUy;
                AppMethodBeat.o(138941);
                return yVar;
            }
        });
        this.spx.a(this.soE, z);
        this.spz.setOnClickListener(new AnonymousClass2(this));
        this.tBv = new com.tencent.mm.plugin.story.ui.view.gallery.GalleryRecyclerView.b();
        this.spq.setAdapter(this.tBv);
        this.spq.setFocusable(false);
        this.spq.setOnRowSelected(new AnonymousClass3(this));
        this.spq.setOnScrollCallback(new AnonymousClass4(this));
        this.tBv.tBr = new AnonymousClass5(this);
        this.spx.setOnClose(new AnonymousClass6(this));
        this.spx.setOnMenu(new a.f.a.a<y>(this) {
            final /* synthetic */ l spK;

            @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$7$1 */
            static final class AnonymousClass1 extends a.f.b.k implements a.f.a.a<y> {
                final /* synthetic */ AnonymousClass7 spL;

                AnonymousClass1(AnonymousClass7 anonymousClass7) {
                    this.spL = anonymousClass7;
                    super(0);
                }

                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.i(138946);
                    l.u(this.spL.spK);
                    y yVar = y.AUy;
                    AppMethodBeat.o(138946);
                    return yVar;
                }
            }

            @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$7$2 */
            static final class AnonymousClass2 extends a.f.b.k implements a.f.a.a<y> {
                final /* synthetic */ AnonymousClass7 spL;

                AnonymousClass2(AnonymousClass7 anonymousClass7) {
                    this.spL = anonymousClass7;
                    super(0);
                }

                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.i(138947);
                    l.s(this.spL.spK);
                    y yVar = y.AUy;
                    AppMethodBeat.o(138947);
                    return yVar;
                }
            }

            @a.l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "", "invoke"})
            /* renamed from: com.tencent.mm.plugin.story.ui.view.gallery.l$7$4 */
            static final class AnonymousClass4 extends a.f.b.k implements a.f.a.a<y> {
                final /* synthetic */ AnonymousClass7 spL;

                AnonymousClass4(AnonymousClass7 anonymousClass7) {
                    this.spL = anonymousClass7;
                    super(0);
                }

                public final /* synthetic */ Object invoke() {
                    AppMethodBeat.i(138949);
                    l.t(this.spL.spK);
                    y yVar = y.AUy;
                    AppMethodBeat.o(138949);
                    return yVar;
                }
            }

            /* JADX WARNING: Removed duplicated region for block: B:105:0x01fa  */
            /* JADX WARNING: Removed duplicated region for block: B:31:0x00d2  */
            /* JADX WARNING: Removed duplicated region for block: B:33:0x00d5  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final /* synthetic */ Object invoke() {
                AppMethodBeat.i(110783);
                if (this.spK.czr) {
                    int size = this.spK.spr.size();
                    int g = this.spK.rZb;
                    if (g >= 0 && size > g) {
                        size = ((ArrayList) this.spK.spr.get(this.spK.rZb)).size();
                        g = this.spK.spn;
                        if (g >= 0 && size > g) {
                            Object obj;
                            boolean z;
                            Object obj2 = ((ArrayList) this.spK.spr.get(this.spK.rZb)).get(this.spK.spn);
                            a.f.b.j.o(obj2, "galleryGroups[selectedRow][selectedColumn]");
                            final com.tencent.mm.plugin.story.model.d.g gVar = (com.tencent.mm.plugin.story.model.d.g) obj2;
                            a o = this.spK.spy;
                            if (o != null) {
                                o.dismiss();
                            }
                            this.spK.spy = new a(context);
                            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
                            com.tencent.mm.plugin.story.h.j Fe = com.tencent.mm.plugin.story.model.j.a.cxT().Fe(gVar.rVZ.cNE);
                            if (Fe != null) {
                                if ((Fe.cBT() ? Fe : null) != null) {
                                    o = this.spK.spy;
                                    if (o != null) {
                                        o.snw = true;
                                    }
                                }
                            }
                            if (Fe != null) {
                                if (Fe.field_storyID != 0) {
                                    if (((long) Fe.field_createTime) <= ((long) cb.aaF()) - ((long) ((com.tencent.mm.plugin.story.c.a.a.a) com.tencent.mm.plugin.story.c.a.a.rQZ.Uw()).rRe)) {
                                        obj = 1;
                                    } else {
                                        obj = null;
                                    }
                                    if (obj == null) {
                                        obj = null;
                                        if ((obj == null ? Fe : null) != null) {
                                            o = this.spK.spy;
                                            if (o != null) {
                                                o.sny = false;
                                            }
                                        }
                                    }
                                }
                                obj = 1;
                                if (obj == null) {
                                }
                                if ((obj == null ? Fe : null) != null) {
                                }
                            }
                            if (Fe != null) {
                                obj = (Fe.field_storyID == 0 || Fe.cBX()) ? 1 : null;
                                if ((obj != null ? Fe : null) != null) {
                                    o = this.spK.spy;
                                    if (o != null) {
                                        o.snx = false;
                                    }
                                }
                            }
                            if (this.spK.getGalleryType() == com.tencent.mm.plugin.story.api.m.a.FavSelfStoryGallery) {
                                o = this.spK.spy;
                                if (o != null) {
                                    o.ixx = false;
                                }
                            }
                            a o2 = this.spK.spy;
                            if (o2 != null) {
                                if (Fe == null || !Fe.cBV() || Fe.cBX()) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                o2.rvv = z;
                            }
                            o2 = this.spK.spy;
                            if (o2 != null) {
                                if (Fe == null || !Fe.cBW()) {
                                    z = false;
                                } else {
                                    z = true;
                                }
                                o2.rYr = z;
                            }
                            o = this.spK.spy;
                            if (o != null && o.rvv) {
                                o = this.spK.spy;
                                if (o != null) {
                                    o.sny = false;
                                }
                            }
                            o = this.spK.spy;
                            if (o != null && o.rYr) {
                                o = this.spK.spy;
                                if (o != null) {
                                    o.snx = false;
                                }
                            }
                            o2 = this.spK.spy;
                            if (o2 != null) {
                                o2.sns = new AnonymousClass2(this);
                            }
                            o2 = this.spK.spy;
                            if (o2 != null) {
                                o2.snt = new a.f.a.a<y>(this) {
                                    final /* synthetic */ AnonymousClass7 spL;

                                    public final /* synthetic */ Object invoke() {
                                        AppMethodBeat.i(138948);
                                        l.e(gVar.rVZ);
                                        y yVar = y.AUy;
                                        AppMethodBeat.o(138948);
                                        return yVar;
                                    }
                                };
                            }
                            o = this.spK.spy;
                            if (o != null) {
                                o.snu = new AnonymousClass4(this);
                            }
                            o = this.spK.spy;
                            if (o != null) {
                                o.snv = new AnonymousClass1(this);
                            }
                            a o3 = this.spK.spy;
                            if (o3 != null) {
                                o3.show();
                            }
                            this.spK.shi = true;
                            com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
                            com.tencent.mm.plugin.story.g.h.cAw().bE(7);
                            hVar = com.tencent.mm.plugin.story.g.h.scu;
                            com.tencent.mm.plugin.story.g.h.cAw().fz(String.valueOf(Fe != null ? Long.valueOf(Fe.field_storyID) : null));
                            hVar = com.tencent.mm.plugin.story.g.h.scu;
                            com.tencent.mm.plugin.story.g.h.cAx();
                        }
                    }
                }
                y yVar = y.AUy;
                AppMethodBeat.o(110783);
                return yVar;
            }
        });
        this.skn = AnonymousClass8.spM;
        com.tencent.mm.plugin.story.model.c cVar = com.tencent.mm.plugin.story.model.c.rSd;
        com.tencent.mm.plugin.story.model.c.a(this);
        this.spA = new g(this, this.spq, this.spm);
        com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
        com.tencent.mm.plugin.story.g.h.cAs().bF((long) at.gC(context));
        this.spC = new g(this, context);
        this.spD = -1;
        this.spH = new m(this);
        this.spI = new d(this);
        AppMethodBeat.o(138953);
    }

    static {
        AppMethodBeat.i(110849);
        AppMethodBeat.o(110849);
    }

    public final boolean getVideoViewMgrFromPreLoad() {
        return this.spd;
    }

    public final void setVideoViewMgrFromPreLoad(boolean z) {
        this.spd = z;
    }

    public final boolean getDeleteWhenFirstEmpty() {
        return this.spe;
    }

    public final void setDeleteWhenFirstEmpty(boolean z) {
        this.spe = z;
    }

    public final String getChatRoom() {
        return this.gpx;
    }

    public final void setChatRoom(String str) {
        AppMethodBeat.i(110820);
        this.gpx = str;
        this.spx.setChatRoom(str);
        AppMethodBeat.o(110820);
    }

    public final String getSessionId() {
        return this.cvF;
    }

    public final void setSessionId(String str) {
        this.cvF = str;
    }

    public final void setForSns(boolean z) {
        this.rZI = z;
    }

    public final void setGalleryScaleListener(b bVar) {
        AppMethodBeat.i(110821);
        a.f.b.j.p(bVar, CastExtraArgs.LISTENER);
        this.soz = bVar;
        if (this.soE == com.tencent.mm.plugin.story.api.m.a.MultiUserGallery || this.soE == com.tencent.mm.plugin.story.api.m.a.HistoryGallery || this.soE == com.tencent.mm.plugin.story.api.m.a.FavSelfStoryGallery || this.soE == com.tencent.mm.plugin.story.api.m.a.FavOtherStoryGallery) {
            d dVar = new d();
            dVar.seu = this;
            this.shf.a((e) dVar);
        }
        this.shf.a((e) new h(this, bVar));
        AppMethodBeat.o(110821);
    }

    public final void Fk(int i) {
        AppMethodBeat.i(110822);
        if (this.spr.size() > 0 && ((ArrayList) this.spr.get(0)).size() > i) {
            ab.c(TAG, "checkDoPreloadBeforeEnterGallery", new Object[0]);
            if (((ArrayList) this.spr.get(0)).size() > i && !bo.isNullOrNil(((com.tencent.mm.plugin.story.model.d.g) ((ArrayList) this.spr.get(0)).get(i)).rVZ.rWj.Url)) {
                ab.i(TAG, "checkDoPreloadBeforeEnterGallery, add [0," + i + "] item");
                n nVar = n.sqi;
                n.dK(a.a.l.U(((com.tencent.mm.plugin.story.model.d.g) ((ArrayList) this.spr.get(0)).get(i)).rVZ));
                AppMethodBeat.o(110822);
                return;
            }
        }
        AppMethodBeat.o(110822);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        AppMethodBeat.i(110823);
        a.f.b.j.p(motionEvent, "ev");
        if (this.spt) {
            boolean dispatchTouchEvent;
            MotionEvent obtain;
            g gVar = this.spA;
            if (gVar.soj) {
                com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
                a.f.b.j.o(RP, "storage()");
                RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_GALLERY_FIRST_BOOLEAN_SYNC, Boolean.TRUE);
                gVar.cCG();
            }
            switch (motionEvent.getActionMasked()) {
                case 0:
                    this.shj = false;
                    break;
                case 1:
                case 3:
                    break;
            }
            this.shi = false;
            this.shf.J(motionEvent);
            int i = this.shf.sod;
            if (!(this.shi || this.shh)) {
                int i2;
                if (this.rZb < 0 || this.rZb >= this.spr.size()) {
                    i2 = 0;
                } else {
                    int i3;
                    if (this.spo > 0.0f) {
                        i3 = 2;
                    } else {
                        i3 = 0;
                    }
                    if (this.spo < ((float) (this.spr.size() - 1))) {
                        i3 |= 1;
                    }
                    if (this.spn > 0) {
                        i2 = i3 | 8;
                    } else {
                        i2 = i3;
                    }
                    if (this.spn < ((ArrayList) this.spr.get(this.rZb)).size() - 1) {
                        i2 |= 4;
                    }
                }
                if ((i2 & i) == 0) {
                    dispatchTouchEvent = this.shf.dispatchTouchEvent(motionEvent);
                    if (!this.shi || dispatchTouchEvent) {
                        if (!this.shj) {
                            obtain = MotionEvent.obtain(motionEvent);
                            a.f.b.j.o(obtain, "cancelEvent");
                            obtain.setAction(3);
                            super.dispatchTouchEvent(obtain);
                            obtain.recycle();
                            this.shj = true;
                        }
                        AppMethodBeat.o(110823);
                        return true;
                    }
                    if (!this.shh) {
                        com.tencent.mm.plugin.story.ui.b.b layoutManager = this.spq.getLayoutManager();
                        com.tencent.mm.plugin.story.ui.view.gallery.f.a aVar = f.soh;
                        if ((i & 4) == 0 && (i & 8) == 0) {
                            dispatchTouchEvent = false;
                        } else {
                            dispatchTouchEvent = true;
                        }
                        if (!dispatchTouchEvent) {
                            z = true;
                        }
                        layoutManager.shc = z;
                    }
                    boolean dispatchTouchEvent2 = super.dispatchTouchEvent(motionEvent);
                    AppMethodBeat.o(110823);
                    return dispatchTouchEvent2;
                }
            }
            if (!this.shj) {
                obtain = MotionEvent.obtain(motionEvent);
                a.f.b.j.o(obtain, "cancelEvent");
                obtain.setAction(3);
                this.shf.dispatchTouchEvent(obtain);
                obtain.recycle();
                this.shj = true;
            }
            dispatchTouchEvent = false;
            if (this.shi) {
            }
            if (this.shj) {
            }
            AppMethodBeat.o(110823);
            return true;
        }
        AppMethodBeat.o(110823);
        return false;
    }

    public final boolean canScrollHorizontally(int i) {
        return this.spt;
    }

    private final void cCJ() {
        AppMethodBeat.i(110824);
        ab.d(TAG, "fadeOutMaskView");
        com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
        com.tencent.mm.plugin.story.g.h.cAs().bI(System.currentTimeMillis());
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.iVh, "alpha", new float[]{1.0f, 0.0f});
        ofFloat.addListener(new f(this));
        ofFloat.start();
        AppMethodBeat.o(110824);
    }

    public final void setNeedReset(boolean z) {
        this.spF = z;
    }

    public final void setFirstPost(boolean z) {
        this.spG = z;
    }

    /* JADX WARNING: Missing block: B:3:0x0014, code skipped:
            if (a.f.b.j.j(com.tencent.mm.plugin.story.model.j.a.cnk(), r5) == false) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setDataSeed(Object obj) {
        boolean z;
        String str;
        AppMethodBeat.i(110825);
        if (obj instanceof String) {
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        }
        if (!(this.soE == com.tencent.mm.plugin.story.api.m.a.HistoryGallery || this.soE == com.tencent.mm.plugin.story.api.m.a.FavSelfStoryGallery)) {
            z = false;
            this.czr = z;
            str = this.gpx;
            if (str == null && (obj instanceof ArrayList) && ((ArrayList) obj).isEmpty()) {
                ab.i(TAG, "setDataSeed: chat room empty user list, fetch again");
                com.tencent.mm.plugin.story.model.f.d dVar = new com.tencent.mm.plugin.story.model.f.d(str);
                dVar.rXb = new p(this, dVar);
                dVar.start();
                AppMethodBeat.o(110825);
                return;
            }
            setDataInternal(obj);
            AppMethodBeat.o(110825);
        }
        z = true;
        this.czr = z;
        str = this.gpx;
        if (str == null) {
        }
        setDataInternal(obj);
        AppMethodBeat.o(110825);
    }

    private final void setDataInternal(Object obj) {
        int i;
        AppMethodBeat.i(110826);
        com.tencent.mm.plugin.story.f.f fVar = com.tencent.mm.plugin.story.f.f.rZu;
        this.sps = com.tencent.mm.plugin.story.f.f.a(obj, this.spC, this.soE, this.gpx, this.rZI);
        com.tencent.mm.plugin.story.f.h hVar = this.sps;
        if (hVar != null) {
            hVar.ET(this.rZE);
        }
        ab.i(TAG, "presenter " + this.sps + " galleryType " + this.soE);
        hVar = this.sps;
        if (hVar != null) {
            hVar.czC();
        }
        this.spx.setVisibility(0);
        switch (m.eQZ[this.soE.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                i = 1;
                break;
            default:
                i = 0;
                break;
        }
        if (i == 0) {
            GalleryVerticalControlView galleryVerticalControlView = this.spx;
            galleryVerticalControlView.sif.setVisibility(0);
            galleryVerticalControlView.soC.setVisibility(8);
        } else if (obj instanceof com.tencent.mm.plugin.story.api.o) {
            this.spx.setUserList(com.tencent.mm.plugin.story.model.d.e.a((com.tencent.mm.plugin.story.api.o) obj));
        } else if (obj instanceof List) {
            this.spx.setUserList((List) obj);
        }
        if (this.soE == com.tencent.mm.plugin.story.api.m.a.SelfTabGallery && (getLayoutParams() instanceof MarginLayoutParams)) {
            GalleryHolderView galleryHolderView = this.spz;
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams == null) {
                v vVar = new v("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(110826);
                throw vVar;
            }
            galleryHolderView.setInitMargin(((MarginLayoutParams) layoutParams).topMargin);
        }
        AppMethodBeat.o(110826);
    }

    public final void a(PullDownListView pullDownListView) {
        AppMethodBeat.i(110827);
        this.spf = pullDownListView;
        this.spw = new c();
        c cVar = this.spw;
        if (cVar != null) {
            cVar.snE = this;
        }
        c cVar2 = this.spw;
        if (cVar2 != null) {
            cVar2.snD = pullDownListView;
        }
        cVar2 = this.spw;
        if (cVar2 != null) {
            this.shf.a((e) cVar2);
            AppMethodBeat.o(110827);
            return;
        }
        AppMethodBeat.o(110827);
    }

    public final void onResume() {
        AppMethodBeat.i(110828);
        ab.i(TAG, "LogStory: onResume " + hashCode() + ", galleryType:" + this.soE + " videoViewMgr " + this.soY);
        this.dirty = true;
        cCK();
        com.tencent.mm.plugin.story.f.h hVar = this.sps;
        if (hVar != null) {
            hVar.resume();
        }
        p pVar = this.soY;
        if (pVar != null) {
            pVar.akW();
        }
        StoryGalleryItemView storyGalleryItemView = this.sph;
        if (!(storyGalleryItemView == null || storyGalleryItemView.getCommentView() == null)) {
            StoryCommentView.resume();
        }
        com.tencent.mm.plugin.story.g.c cVar = com.tencent.mm.plugin.story.g.c.sbQ;
        com.tencent.mm.plugin.story.g.c.czR();
        com.tencent.mm.plugin.story.g.b bVar = com.tencent.mm.plugin.story.g.b.sbw;
        com.tencent.mm.plugin.story.g.b.czR();
        if (this.spt) {
            storyGalleryItemView = this.sph;
            if (storyGalleryItemView != null) {
                storyGalleryItemView.cCI();
                AppMethodBeat.o(110828);
                return;
            }
        }
        AppMethodBeat.o(110828);
    }

    public final void onStart() {
        AppMethodBeat.i(110829);
        ab.i(TAG, "LogStory, onStart " + hashCode() + " galleryType:" + this.soE);
        AppMethodBeat.o(110829);
    }

    public final void onPause() {
        AppMethodBeat.i(110830);
        ab.i(TAG, "LogStory: onPause " + hashCode() + " galleryType:" + this.soE + " videoViewMgr " + this.soY);
        this.dirty = true;
        com.tencent.mm.plugin.story.f.h hVar = this.sps;
        if (hVar != null) {
            hVar.pause();
        }
        p pVar = this.soY;
        if (pVar != null) {
            pVar.akV();
        }
        StoryGalleryItemView storyGalleryItemView = this.sph;
        if (!(storyGalleryItemView == null || storyGalleryItemView.getCommentView() == null)) {
            StoryCommentView.pause();
        }
        a aVar = this.spy;
        if (aVar != null) {
            aVar.dismiss();
        }
        com.tencent.mm.plugin.story.g.h hVar2 = com.tencent.mm.plugin.story.g.h.scu;
        com.tencent.mm.plugin.story.g.h.EX(11);
        com.tencent.mm.plugin.story.model.b.b bVar = com.tencent.mm.plugin.story.model.b.b.rVw;
        com.tencent.mm.plugin.story.model.b.b.cyZ();
        reset();
        AppMethodBeat.o(110830);
    }

    public final void onStop() {
        AppMethodBeat.i(110831);
        ab.i(TAG, "LogStory, onStop:" + hashCode());
        AppMethodBeat.o(110831);
    }

    public final void onDestroy() {
        AppMethodBeat.i(110832);
        ab.i(TAG, "LogStory, onDestroy " + hashCode() + " galleryType:" + this.soE + " videoViewMgr " + this.soY);
        com.tencent.mm.plugin.story.model.c cVar = com.tencent.mm.plugin.story.model.c.rSd;
        com.tencent.mm.plugin.story.model.c.b(this);
        db();
        com.tencent.mm.plugin.story.f.h hVar = this.sps;
        if (hVar != null) {
            hVar.destroy();
        }
        com.tencent.mm.plugin.story.f.l lVar = com.tencent.mm.plugin.story.f.l.sac;
        com.tencent.mm.plugin.story.f.l.czJ();
        StoryGalleryItemView storyGalleryItemView = this.sph;
        if (storyGalleryItemView != null) {
            StoryCommentView commentView = storyGalleryItemView.getCommentView();
            if (commentView != null) {
                commentView.destroy();
            }
        }
        p pVar = this.soY;
        if (pVar != null) {
            pVar.aEX();
        }
        n nVar = n.sqi;
        n.cCO();
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.model.j.a.cya().rXL = null;
        nVar = n.sqi;
        int cCR = n.cCR();
        ab.i(TAG, "onDestroy speed " + cCR + ' ');
        com.tencent.mm.plugin.story.g.b bVar = com.tencent.mm.plugin.story.g.b.sbw;
        com.tencent.mm.plugin.story.g.b.EW(cCR);
        this.spA.destroy();
        AppMethodBeat.o(110832);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean wY() {
        boolean Ab;
        com.tencent.mm.plugin.story.api.g gVar;
        boolean z = false;
        AppMethodBeat.i(110833);
        com.tencent.mm.plugin.story.g.h hVar = com.tencent.mm.plugin.story.g.h.scu;
        com.tencent.mm.plugin.story.g.h.EX(10);
        StoryGalleryItemView storyGalleryItemView = this.sph;
        if (storyGalleryItemView != null) {
            StoryCommentView commentView = storyGalleryItemView.getCommentView();
            if (commentView != null) {
                Ab = commentView.Ab();
                ab.d(TAG, "onBackPressed commentView result:".concat(String.valueOf(Ab)));
                if (!Ab && this.spt) {
                    gVar = this.spu;
                    if (gVar != null) {
                        gVar.caC();
                    }
                    if (Ab || this.spt) {
                        z = true;
                    }
                    Ab = z;
                }
                ab.d(TAG, "onBackPressed result:".concat(String.valueOf(Ab)));
                AppMethodBeat.o(110833);
                return Ab;
            }
        }
        Ab = false;
        ab.d(TAG, "onBackPressed commentView result:".concat(String.valueOf(Ab)));
        gVar = this.spu;
        if (gVar != null) {
        }
        z = true;
        Ab = z;
        ab.d(TAG, "onBackPressed result:".concat(String.valueOf(Ab)));
        AppMethodBeat.o(110833);
        return Ab;
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0227  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x019c  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0227  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void K(boolean z, boolean z2) {
        com.tencent.mm.storage.ac.a aVar;
        String str = null;
        AppMethodBeat.i(110834);
        ab.i(TAG, "LogStory: onSwitchVideoMode isMute:" + z + " videoViewMgr " + this.soY + " videoViewMgrFromPreLoad " + this.spd);
        this.spq.setActive(true);
        this.spt = true;
        this.eif = z;
        StoryGalleryItemView storyGalleryItemView = this.sph;
        if (storyGalleryItemView != null) {
            storyGalleryItemView.setMute(z);
        }
        if (this.spr.size() > 0 && this.rZb >= 0 && this.rZb < this.spr.size() && this.spn < ((ArrayList) this.spr.get(this.rZb)).size() && this.spn >= 0) {
            ab.i(TAG, "help LogStory: onItemSelected " + this.spt);
            com.tencent.mm.plugin.story.model.d.i iVar = ((com.tencent.mm.plugin.story.model.d.g) ((ArrayList) this.spr.get(this.rZb)).get(this.spn)).rVZ;
            n nVar = n.sqi;
            n.e(this.spr, this.rZb, this.spn);
            n.sqi.f(iVar);
        }
        storyGalleryItemView = this.sph;
        if (storyGalleryItemView != null) {
            storyGalleryItemView.cCI();
        }
        p pVar;
        if (this.spd) {
            pVar = this.soY;
            if (pVar != null) {
                pVar.cDf();
            }
        } else {
            pVar = this.soY;
            if (pVar != null) {
                pVar.cDe();
            }
        }
        setEnabled(true);
        com.tencent.mm.plugin.story.f.h hVar = this.sps;
        if (hVar != null) {
            hVar.EO(1);
        }
        if (!(this.soE == com.tencent.mm.plugin.story.api.m.a.HistoryGallery || this.soE == com.tencent.mm.plugin.story.api.m.a.MultiUserGallery || this.soE == com.tencent.mm.plugin.story.api.m.a.FavSelfStoryGallery || this.soE == com.tencent.mm.plugin.story.api.m.a.FavOtherStoryGallery)) {
            Fk(1);
        }
        if (this.soE == com.tencent.mm.plugin.story.api.m.a.SelfTabGallery && this.spz.getVisibility() == 0) {
            this.spz.cCF();
        }
        if (this.soE == com.tencent.mm.plugin.story.api.m.a.SelfTabGallery) {
            aVar = com.tencent.mm.storage.ac.a.USERINFO_STORY_PULL_DOWN_MORE_TAB_FIRST_BOOLEAN_SYNC;
        } else if (this.soE == com.tencent.mm.plugin.story.api.m.a.ProfileGallery) {
            aVar = com.tencent.mm.storage.ac.a.USERINFO_STORY_PULL_DOWN_PROFILE_FIRST_BOOLEAN_SYNC;
        } else {
            aVar = null;
        }
        com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
        a.f.b.j.o(RP, "storage()");
        RP.Ry().set(aVar, Boolean.TRUE);
        this.spg.setVisibility(8);
        if (z2) {
            String str2;
            Object valueOf;
            com.tencent.mm.plugin.story.g.h hVar2 = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.plugin.story.g.h.cAv();
            hVar2 = com.tencent.mm.plugin.story.g.h.scu;
            storyGalleryItemView = this.sph;
            if (storyGalleryItemView != null) {
                com.tencent.mm.plugin.story.model.d.i videoItem = storyGalleryItemView.getVideoItem();
                if (videoItem != null) {
                    str2 = videoItem.username;
                    if (!com.tencent.mm.plugin.story.g.h.aaP(str2)) {
                        hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                        com.tencent.mm.plugin.story.g.h.cAs().bK(1);
                        storyGalleryItemView = this.sph;
                        if (storyGalleryItemView != null) {
                            videoItem = storyGalleryItemView.getVideoItem();
                            if (videoItem != null) {
                                str2 = videoItem.username;
                                if (com.tencent.mm.model.t.mY(str2)) {
                                    hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                                    com.tencent.mm.plugin.story.g.h.cAs().bL(1);
                                }
                            }
                        }
                        str2 = null;
                        if (com.tencent.mm.model.t.mY(str2)) {
                        }
                    }
                    hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                    com.tencent.mm.plugin.story.g.h.cAs().bO(1);
                    storyGalleryItemView = this.sph;
                    if (storyGalleryItemView != null) {
                        videoItem = storyGalleryItemView.getVideoItem();
                        if (videoItem != null) {
                            str2 = videoItem.username;
                            if (com.tencent.mm.model.t.mY(str2)) {
                                hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                                com.tencent.mm.plugin.story.g.h.cAs().bP(1);
                            }
                            hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                            storyGalleryItemView = this.sph;
                            if (storyGalleryItemView != null) {
                                videoItem = storyGalleryItemView.getVideoItem();
                                if (videoItem != null) {
                                    valueOf = Long.valueOf(videoItem.rUJ);
                                    if (!com.tencent.mm.plugin.story.g.h.aaQ(String.valueOf(valueOf))) {
                                        hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                                        com.tencent.mm.plugin.story.g.h.cAs().bM(1);
                                        storyGalleryItemView = this.sph;
                                        if (storyGalleryItemView != null) {
                                            videoItem = storyGalleryItemView.getVideoItem();
                                            if (videoItem != null) {
                                                str = videoItem.username;
                                            }
                                        }
                                        if (com.tencent.mm.model.t.mY(str)) {
                                            hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                                            com.tencent.mm.plugin.story.g.h.cAs().bN(1);
                                        }
                                    }
                                    hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                                    com.tencent.mm.plugin.story.g.h.cAs().bQ(1);
                                    hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                                    com.tencent.mm.plugin.story.g.h.cAs().bI(System.currentTimeMillis());
                                    hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                                    com.tencent.mm.plugin.story.g.h.cAl();
                                    if (this.spr.size() != 1 && ((ArrayList) this.spr.get(0)).size() == 0) {
                                        hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                                        com.tencent.mm.plugin.story.g.h.cAu();
                                        AppMethodBeat.o(110834);
                                        return;
                                    } else if (this.spr.size() > this.rZb || this.rZb < 0 || this.spn < 0 || ((ArrayList) this.spr.get(this.rZb)).size() <= this.spn) {
                                        hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                                        com.tencent.mm.plugin.story.g.h.cAu();
                                        AppMethodBeat.o(110834);
                                        return;
                                    } else {
                                        cCL();
                                        lL(true);
                                        hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                                        au cAG = com.tencent.mm.plugin.story.g.h.cAG();
                                        com.tencent.mm.plugin.story.g.h hVar3 = com.tencent.mm.plugin.story.g.h.scu;
                                        cAG.cg(com.tencent.mm.plugin.story.g.h.cAs().FH());
                                        hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                                        cAG = com.tencent.mm.plugin.story.g.h.cAG();
                                        hVar3 = com.tencent.mm.plugin.story.g.h.scu;
                                        cAG.ce(com.tencent.mm.plugin.story.g.h.cAs().FF());
                                        hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                                        cAG = com.tencent.mm.plugin.story.g.h.cAG();
                                        hVar3 = com.tencent.mm.plugin.story.g.h.scu;
                                        cAG.cf(com.tencent.mm.plugin.story.g.h.cAs().FG());
                                        hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                                        com.tencent.mm.plugin.story.g.h.cAG().fF(((com.tencent.mm.plugin.story.model.d.g) ((ArrayList) this.spr.get(this.rZb)).get(this.spn)).userName);
                                        hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                                        com.tencent.mm.plugin.story.g.h.cAG().fG(String.valueOf(((com.tencent.mm.plugin.story.model.d.g) ((ArrayList) this.spr.get(this.rZb)).get(this.spn)).rUJ));
                                        hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                                        com.tencent.mm.plugin.story.g.h.cAH();
                                        AppMethodBeat.o(110834);
                                        return;
                                    }
                                }
                            }
                            valueOf = null;
                            if (com.tencent.mm.plugin.story.g.h.aaQ(String.valueOf(valueOf))) {
                            }
                            hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                            com.tencent.mm.plugin.story.g.h.cAs().bQ(1);
                            hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                            com.tencent.mm.plugin.story.g.h.cAs().bI(System.currentTimeMillis());
                            hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                            com.tencent.mm.plugin.story.g.h.cAl();
                            if (this.spr.size() != 1) {
                            }
                            if (this.spr.size() > this.rZb) {
                            }
                            hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                            com.tencent.mm.plugin.story.g.h.cAu();
                            AppMethodBeat.o(110834);
                            return;
                        }
                    }
                    str2 = null;
                    if (com.tencent.mm.model.t.mY(str2)) {
                    }
                    hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                    storyGalleryItemView = this.sph;
                    if (storyGalleryItemView != null) {
                    }
                    valueOf = null;
                    if (com.tencent.mm.plugin.story.g.h.aaQ(String.valueOf(valueOf))) {
                    }
                    hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                    com.tencent.mm.plugin.story.g.h.cAs().bQ(1);
                    hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                    com.tencent.mm.plugin.story.g.h.cAs().bI(System.currentTimeMillis());
                    hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                    com.tencent.mm.plugin.story.g.h.cAl();
                    if (this.spr.size() != 1) {
                    }
                    if (this.spr.size() > this.rZb) {
                    }
                    hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                    com.tencent.mm.plugin.story.g.h.cAu();
                    AppMethodBeat.o(110834);
                    return;
                }
            }
            str2 = null;
            if (com.tencent.mm.plugin.story.g.h.aaP(str2)) {
            }
            hVar2 = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.plugin.story.g.h.cAs().bO(1);
            storyGalleryItemView = this.sph;
            if (storyGalleryItemView != null) {
            }
            str2 = null;
            if (com.tencent.mm.model.t.mY(str2)) {
            }
            hVar2 = com.tencent.mm.plugin.story.g.h.scu;
            storyGalleryItemView = this.sph;
            if (storyGalleryItemView != null) {
            }
            valueOf = null;
            if (com.tencent.mm.plugin.story.g.h.aaQ(String.valueOf(valueOf))) {
            }
            hVar2 = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.plugin.story.g.h.cAs().bQ(1);
            hVar2 = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.plugin.story.g.h.cAs().bI(System.currentTimeMillis());
            hVar2 = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.plugin.story.g.h.cAl();
            if (this.spr.size() != 1) {
            }
            if (this.spr.size() > this.rZb) {
            }
            hVar2 = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.plugin.story.g.h.cAu();
            AppMethodBeat.o(110834);
            return;
        }
        AppMethodBeat.o(110834);
    }

    public final void lr(boolean z) {
        com.tencent.mm.plugin.story.f.h hVar;
        AppMethodBeat.i(110835);
        ab.i(TAG, "LogStory: onSwitchImageMode videoViewMgr " + this.soY);
        this.spq.setActive(false);
        this.spt = false;
        com.tencent.mm.plugin.story.proxy.c.a aVar = com.tencent.mm.plugin.story.proxy.c.saU;
        com.tencent.mm.plugin.story.proxy.c.a.czN().czM();
        if (this.spF && this.czr) {
            hVar = this.sps;
            if (hVar != null) {
                hVar.czC();
            }
        }
        StoryGalleryItemView storyGalleryItemView = this.sph;
        if (storyGalleryItemView != null) {
            storyGalleryItemView.sfS.oE(2);
            storyGalleryItemView.sfS.hide();
        }
        p pVar = this.soY;
        if (pVar != null) {
            pVar.N(true, z);
        }
        setEnabled(false);
        hVar = this.sps;
        if (hVar != null) {
            hVar.EO(0);
        }
        if (this.soE == com.tencent.mm.plugin.story.api.m.a.SelfTabGallery && this.spz.getVisibility() == 0) {
            GalleryHolderView galleryHolderView = this.spz;
            galleryHolderView.snI.setVisibility(4);
            galleryHolderView.iDT.setVisibility(0);
        }
        lL(false);
        AppMethodBeat.o(110835);
    }

    public final void cwK() {
        AppMethodBeat.i(110836);
        cCJ();
        if (this.soE == com.tencent.mm.plugin.story.api.m.a.SelfTabGallery && this.spz.getVisibility() == 0) {
            this.spz.cCE();
        }
        com.tencent.mm.plugin.story.f.h hVar = this.sps;
        if (hVar != null) {
            hVar.czE();
            AppMethodBeat.o(110836);
            return;
        }
        AppMethodBeat.o(110836);
    }

    public final void cwL() {
        AppMethodBeat.i(110837);
        if (this.spr.size() == 1 && ((ArrayList) this.spr.get(0)).isEmpty()) {
            cCJ();
        } else {
            ab.d(TAG, "fadeInMaskView");
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.iVh, "alpha", new float[]{0.0f, 1.0f});
            ofFloat.addListener(new e(this));
            ofFloat.start();
        }
        if (this.soE == com.tencent.mm.plugin.story.api.m.a.SelfTabGallery && this.spz.getVisibility() == 0) {
            GalleryHolderView galleryHolderView = this.spz;
            AnimatorSet animatorSet = new AnimatorSet();
            r3 = new Animator[2];
            r3[0] = ObjectAnimator.ofFloat(galleryHolderView.iDT, "alpha", new float[]{galleryHolderView.iDT.getAlpha(), galleryHolderView.snN});
            r3[1] = ObjectAnimator.ofFloat(galleryHolderView.snI, "alpha", new float[]{galleryHolderView.snI.getAlpha(), 0.0f});
            animatorSet.playTogether(r3);
            animatorSet.setDuration(100);
            animatorSet.start();
        }
        AppMethodBeat.o(110837);
    }

    public final void setStoryBrowseUIListener(com.tencent.mm.plugin.story.api.g gVar) {
        if (gVar != null) {
            this.spu = gVar;
        }
    }

    public final void setCurrentVItem(int i) {
        AppMethodBeat.i(110838);
        if (i < this.spr.size()) {
            ab.d(TAG, "setCurrentVItem " + i + ", all:" + this.spr.size());
            GalleryRecyclerView galleryRecyclerView = this.spq;
            if (galleryRecyclerView != null) {
                galleryRecyclerView.post(new o(this, i));
                AppMethodBeat.o(110838);
                return;
            }
        }
        AppMethodBeat.o(110838);
    }

    public final void setCurrentHItem(int i) {
        AppMethodBeat.i(110839);
        if (this.rZb != -1 && this.rZb < this.spr.size() && i < ((ArrayList) this.spr.get(this.rZb)).size()) {
            RecyclerView recyclerView = this.spi;
            if (recyclerView != null) {
                recyclerView.post(new n(this, i));
                AppMethodBeat.o(110839);
                return;
            }
        }
        AppMethodBeat.o(110839);
    }

    public final void Pb() {
        AppMethodBeat.i(110840);
        com.tencent.mm.plugin.story.f.h hVar = this.sps;
        if (hVar != null) {
            hVar.czC();
        }
        reset();
        AppMethodBeat.o(110840);
    }

    private void reset() {
        AppMethodBeat.i(110841);
        ab.i(TAG, "reset " + bo.dpG() + " isFirstPost : " + this.spG);
        if (this.spG && this.spt) {
            lr(false);
        }
        if (this.spG) {
            com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
            a.f.b.j.o(RP, "MMKernel.storage()");
            RP.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_POST_FIRST_TO_AUTOPLAY_BOOLEAN_SYNC, Boolean.FALSE);
            this.spG = false;
        }
        AppMethodBeat.o(110841);
    }

    public final void EF(int i) {
        AppMethodBeat.i(110842);
        ab.d(TAG, "onOpening ".concat(String.valueOf(i)));
        if (this.soE == com.tencent.mm.plugin.story.api.m.a.SelfTabGallery && this.spz.getVisibility() == 0) {
            GalleryHolderView galleryHolderView = this.spz;
            float min = Math.min(((float) Math.abs(i)) / ((float) Math.abs(galleryHolderView.snM)), 1.0f);
            float f = 1.0f - min;
            galleryHolderView.snI.setAlpha(min);
            galleryHolderView.iDT.setAlpha(f);
            galleryHolderView.snI.setVisibility(0);
        }
        AppMethodBeat.o(110842);
    }

    public final void EG(int i) {
        AppMethodBeat.i(110843);
        ab.d(TAG, "onClosing ".concat(String.valueOf(i)));
        if (this.soE == com.tencent.mm.plugin.story.api.m.a.SelfTabGallery && this.spz.getVisibility() == 0) {
            GalleryHolderView galleryHolderView = this.spz;
            float min = Math.min(1.0f, ((float) Math.abs(i)) / ((float) Math.abs(galleryHolderView.snM)));
            galleryHolderView.snI.setAlpha(1.0f - min);
            galleryHolderView.iDT.setAlpha(min);
            galleryHolderView.snI.setVisibility(0);
        }
        AppMethodBeat.o(110843);
    }

    public final void AW(int i) {
        AppMethodBeat.i(110844);
        ab.d(TAG, "onListInnerScroll ".concat(String.valueOf(i)));
        if (this.soE == com.tencent.mm.plugin.story.api.m.a.SelfTabGallery && this.spz.getVisibility() == 0) {
            GalleryHolderView galleryHolderView = this.spz;
            float min = 1.0f - Math.min(((float) Math.abs(i)) / ((float) com.tencent.mm.bz.a.fromDPToPix(galleryHolderView.getContext(), 16)), 1.0f);
            ab.d(GalleryHolderView.TAG, "onListInnerScroll " + i + ' ' + min);
            galleryHolderView.iDT.setAlpha(min);
            galleryHolderView.snN = min;
        }
        AppMethodBeat.o(110844);
    }

    public final void setCanDragScale(boolean z) {
        this.spv = z;
    }

    private final void cCK() {
        AppMethodBeat.i(110845);
        if (this.czr) {
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cya().a((com.tencent.mm.plugin.story.api.j) this.spH);
            aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cya().e(new c(this));
        }
        AppMethodBeat.o(110845);
    }

    private final void db() {
        AppMethodBeat.i(110846);
        if (this.czr) {
            ab.i(TAG, "removeListeners");
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.model.j.a.cya().b(this.spH);
        }
        AppMethodBeat.o(110846);
    }

    private final void cCL() {
        AppMethodBeat.i(110847);
        String str = TAG;
        StringBuilder stringBuilder = new StringBuilder("addVideoReadNumber ");
        StoryGalleryItemView storyGalleryItemView = this.sph;
        if (storyGalleryItemView == null) {
            a.f.b.j.dWJ();
        }
        com.tencent.mm.plugin.story.model.d.i videoItem = storyGalleryItemView.getVideoItem();
        if (videoItem == null) {
            a.f.b.j.dWJ();
        }
        ab.d(str, stringBuilder.append(videoItem.rUJ).append("  time:").append(System.currentTimeMillis()).toString());
        al.af(this.spI);
        al.n(this.spI, 500);
        AppMethodBeat.o(110847);
    }

    private final void lL(boolean z) {
        AppMethodBeat.i(138952);
        ab.i(TAG, "toggleActiveState ".concat(String.valueOf(z)));
        StoryGalleryItemView storyGalleryItemView = this.sph;
        if (storyGalleryItemView != null) {
            StoryCommentView commentView = storyGalleryItemView.getCommentView();
            if (commentView != null) {
                commentView.lL(z);
            }
        }
        this.spx.lL(z);
        AppMethodBeat.o(138952);
    }

    /* JADX WARNING: Removed duplicated region for block: B:98:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0324  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(l lVar, int i, View view) {
        StoryCommentView commentView;
        AppMethodBeat.i(110850);
        ab.i(TAG, "LogStory: onItemSelected " + i + ", active:" + lVar.spt);
        lVar.spn = i;
        com.tencent.mm.plugin.story.f.h hVar = lVar.sps;
        if (hVar != null) {
            hVar.fN(lVar.rZb, lVar.spn);
        }
        StoryGalleryItemView storyGalleryItemView = lVar.sph;
        if (storyGalleryItemView != null) {
            commentView = storyGalleryItemView.getCommentView();
            if (commentView != null) {
                commentView.setStateChangeCallback(null);
            }
        }
        storyGalleryItemView = lVar.sph;
        if (storyGalleryItemView != null) {
            commentView = storyGalleryItemView.getCommentView();
            if (commentView != null) {
                commentView.hide();
            }
        }
        storyGalleryItemView = lVar.sph;
        if (storyGalleryItemView != null) {
            ImageView thumbView = storyGalleryItemView.getThumbView();
            if (thumbView != null) {
                thumbView.setImageDrawable(null);
            }
        }
        int size = ((ArrayList) lVar.spr.get(lVar.rZb)).size();
        int i2 = lVar.spn;
        if (i2 < 0) {
            AppMethodBeat.o(110850);
        } else if (size <= i2) {
            AppMethodBeat.o(110850);
        } else {
            String str;
            Object obj;
            com.tencent.mm.plugin.story.model.d.i iVar = ((com.tencent.mm.plugin.story.model.d.g) ((ArrayList) lVar.spr.get(lVar.rZb)).get(lVar.spn)).rVZ;
            com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
            com.tencent.mm.plugin.story.h.j Fe = com.tencent.mm.plugin.story.model.j.a.cxT().Fe(iVar.cNE);
            if (lVar.spt) {
                n nVar = n.sqi;
                n.e(lVar.spr, lVar.rZb, lVar.spn);
                n.sqi.f(iVar);
            }
            ab.i(TAG, "LogStory: onItemSelected " + i + " selectedRow " + lVar.rZb + " item: " + ((com.tencent.mm.plugin.story.model.d.g) ((ArrayList) lVar.spr.get(lVar.rZb)).get(lVar.spn)).rVZ + " isMute " + lVar.eif);
            lVar.sph = (StoryGalleryItemView) view;
            storyGalleryItemView = lVar.sph;
            if (storyGalleryItemView != null) {
                storyGalleryItemView.setVideoViewMgr(lVar.soY);
            }
            storyGalleryItemView = lVar.sph;
            if (storyGalleryItemView != null) {
                storyGalleryItemView.setMute(lVar.eif);
            }
            StoryGalleryItemView storyGalleryItemView2 = lVar.sph;
            if (storyGalleryItemView2 != null) {
                storyGalleryItemView2.rVZ = iVar;
                if (iVar != null) {
                    p pVar = storyGalleryItemView2.soY;
                    if (pVar != null) {
                        pVar.a(storyGalleryItemView2.soW, storyGalleryItemView2.soX);
                    }
                    p pVar2 = storyGalleryItemView2.soY;
                    if (pVar2 != null) {
                        pVar2.o(iVar);
                    }
                    storyGalleryItemView2.soW.setVisibility(0);
                }
            }
            storyGalleryItemView = lVar.sph;
            if (storyGalleryItemView != null) {
                com.tencent.mm.plugin.story.model.d.i iVar2 = storyGalleryItemView.rVZ;
                if (iVar2 != null) {
                    az Mp = az.dtm().Mp(iVar2.fDG);
                    if (!iVar2.cze()) {
                        com.tencent.mm.plugin.story.model.j.a aVar2 = com.tencent.mm.plugin.story.model.j.rST;
                        com.tencent.mm.loader.d cyc = com.tencent.mm.plugin.story.model.j.a.cyc();
                        cek cek = iVar2.rWj;
                        str = iVar2.username;
                        a.f.b.j.o(Mp, "fromScene");
                        cyc.aO(new com.tencent.mm.plugin.story.model.c.d(cek, str, Mp)).d(storyGalleryItemView.mmB);
                    } else if (iVar2.rWl == null) {
                        com.tencent.mm.loader.e eVar = com.tencent.mm.loader.e.eOD;
                        com.tencent.mm.loader.e.Tb().lR("").d(storyGalleryItemView.mmB);
                    } else {
                        cee cee = iVar2.rWl;
                        if (cee != null) {
                            ab.i(storyGalleryItemView.TAG, "load fake localFile:" + cee.thumbPath + ", position:" + storyGalleryItemView.position + ", videoPath:" + cee.videoPath);
                            com.tencent.mm.loader.e eVar2 = com.tencent.mm.loader.e.eOD;
                            com.tencent.mm.loader.a Tb = com.tencent.mm.loader.e.Tb();
                            str = cee.thumbPath;
                            a.f.b.j.o(str, "it.thumbPath");
                            Tb.lR(str).d(storyGalleryItemView.mmB);
                        }
                    }
                }
            }
            storyGalleryItemView = lVar.sph;
            if (storyGalleryItemView != null) {
                if (lVar.spt) {
                    com.tencent.mm.plugin.story.g.c cVar = com.tencent.mm.plugin.story.g.c.sbQ;
                    str = iVar.username;
                    storyGalleryItemView.d(iVar);
                    com.tencent.mm.plugin.story.g.c.ar(str, iVar.rUJ);
                    com.tencent.mm.plugin.story.g.b bVar = com.tencent.mm.plugin.story.g.b.sbw;
                    str = iVar.username;
                    storyGalleryItemView.d(iVar);
                    com.tencent.mm.plugin.story.g.b.j(str, iVar.rUJ, lVar.spn);
                }
                com.tencent.mm.plugin.story.g.c cVar2 = com.tencent.mm.plugin.story.g.c.sbQ;
                com.tencent.mm.plugin.story.g.c.b(lVar.spr, lVar.rZb, lVar.spn);
                com.tencent.mm.plugin.story.g.b bVar2 = com.tencent.mm.plugin.story.g.b.sbw;
                com.tencent.mm.plugin.story.g.b.b(lVar.spr, lVar.rZb, lVar.spn);
            }
            storyGalleryItemView = lVar.sph;
            if (storyGalleryItemView != null) {
                StoryCommentView commentView2 = storyGalleryItemView.getCommentView();
                if (commentView2 != null) {
                    commentView2.setStateChangeCallback(new i(lVar));
                }
            }
            storyGalleryItemView = lVar.sph;
            if (storyGalleryItemView != null) {
                commentView = storyGalleryItemView.getCommentView();
                if (commentView != null) {
                    commentView.setOutsideClickListener(lVar.skn);
                }
            }
            if (lVar.spt) {
                storyGalleryItemView = lVar.sph;
                if (storyGalleryItemView != null) {
                    commentView = storyGalleryItemView.getCommentView();
                    if (commentView != null) {
                        commentView.show();
                    }
                }
            } else {
                storyGalleryItemView = lVar.sph;
                if (storyGalleryItemView != null) {
                    commentView = storyGalleryItemView.getCommentView();
                    if (commentView != null) {
                        commentView.hide();
                    }
                }
            }
            storyGalleryItemView = lVar.sph;
            if (storyGalleryItemView != null) {
                commentView = storyGalleryItemView.getCommentView();
                if (commentView != null) {
                    commentView.setSessionId(lVar.cvF);
                }
            }
            GalleryHorizontalControlView galleryHorizontalControlView = lVar.spj;
            if (galleryHorizontalControlView != null) {
                galleryHorizontalControlView.setSelection(lVar.spn);
            }
            if (lVar.czr) {
                if (lVar.soE != com.tencent.mm.plugin.story.api.m.a.FavSelfStoryGallery) {
                    boolean z;
                    GalleryVerticalControlView galleryVerticalControlView;
                    if (Fe == null || !Fe.cBV() || Fe.cBX()) {
                        z = false;
                    } else {
                        z = true;
                    }
                    if (Fe != null) {
                        if (Fe.cBR().xeC == 0) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (obj == null && !Fe.cBX()) {
                            obj = 1;
                            lVar.spx.lT(z);
                            if (!z) {
                                lVar.spx.lU(Fe == null ? false : Fe.cBW());
                            }
                            galleryVerticalControlView = lVar.spx;
                            if (obj == null && com.tencent.mm.plugin.story.c.a.a.rQZ.cxh()) {
                                galleryVerticalControlView.soB.setVisibility(0);
                                galleryVerticalControlView.soB.setImageDrawable(com.tencent.mm.ui.ah.f(galleryVerticalControlView.getContext(), R.raw.icons_filled_moment_off, galleryVerticalControlView.getResources().getColor(R.color.a29)));
                            } else {
                                galleryVerticalControlView.soB.setVisibility(8);
                            }
                        }
                    }
                    obj = null;
                    lVar.spx.lT(z);
                    if (z) {
                    }
                    galleryVerticalControlView = lVar.spx;
                    if (obj == null) {
                    }
                    galleryVerticalControlView.soB.setVisibility(8);
                }
                lVar.spx.lL(lVar.spt);
            }
            if (lVar.spD == i) {
                lVar.spE = false;
            }
            if (lVar.spD != i && lVar.spt) {
                com.tencent.mm.plugin.story.g.h hVar2;
                String str2;
                obj = ((ArrayList) lVar.spr.get(lVar.rZb)).get(i);
                a.f.b.j.o(obj, "galleryGroups[selectedRow][position]");
                com.tencent.mm.plugin.story.model.d.g gVar = (com.tencent.mm.plugin.story.model.d.g) obj;
                lVar.cCL();
                com.tencent.mm.plugin.story.g.h hVar3 = com.tencent.mm.plugin.story.g.h.scu;
                ar cAs = com.tencent.mm.plugin.story.g.h.cAs();
                cAs.bO(cAs.FM() + 1);
                if (com.tencent.mm.model.t.mY(iVar.username)) {
                    hVar3 = com.tencent.mm.plugin.story.g.h.scu;
                    cAs = com.tencent.mm.plugin.story.g.h.cAs();
                    cAs.bP(cAs.FN() + 1);
                }
                hVar3 = com.tencent.mm.plugin.story.g.h.scu;
                if (!com.tencent.mm.plugin.story.g.h.aaQ(String.valueOf(gVar.rUJ))) {
                    hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                    ar cAs2 = com.tencent.mm.plugin.story.g.h.cAs();
                    cAs2.bM(cAs2.FK() + 1);
                    if (com.tencent.mm.model.t.mY(iVar.username)) {
                        hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                        cAs2 = com.tencent.mm.plugin.story.g.h.cAs();
                        cAs2.bN(cAs2.FL() + 1);
                    }
                }
                if (!lVar.spE) {
                    hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                    com.tencent.mm.plugin.story.g.h.EX(3);
                }
                lVar.spE = false;
                hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                au cAG = com.tencent.mm.plugin.story.g.h.cAG();
                hVar3 = com.tencent.mm.plugin.story.g.h.scu;
                cAG.cg(com.tencent.mm.plugin.story.g.h.cAs().FH());
                hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                cAG = com.tencent.mm.plugin.story.g.h.cAG();
                hVar3 = com.tencent.mm.plugin.story.g.h.scu;
                cAG.ce(com.tencent.mm.plugin.story.g.h.cAs().FF());
                hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                cAG = com.tencent.mm.plugin.story.g.h.cAG();
                hVar3 = com.tencent.mm.plugin.story.g.h.scu;
                cAG.cf(com.tencent.mm.plugin.story.g.h.cAs().FG());
                hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                au cAG2 = com.tencent.mm.plugin.story.g.h.cAG();
                storyGalleryItemView = lVar.sph;
                if (storyGalleryItemView != null) {
                    com.tencent.mm.plugin.story.model.d.i videoItem = storyGalleryItemView.getVideoItem();
                    if (videoItem != null) {
                        str2 = videoItem.username;
                        cAG2.fF(str2);
                        hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                        cAG2 = com.tencent.mm.plugin.story.g.h.cAG();
                        storyGalleryItemView = lVar.sph;
                        if (storyGalleryItemView != null) {
                            videoItem = storyGalleryItemView.getVideoItem();
                            if (videoItem != null) {
                                obj = Long.valueOf(videoItem.rUJ);
                                cAG2.fG(String.valueOf(obj));
                                hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                                com.tencent.mm.plugin.story.g.h.cAH();
                            }
                        }
                        obj = null;
                        cAG2.fG(String.valueOf(obj));
                        hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                        com.tencent.mm.plugin.story.g.h.cAH();
                    }
                }
                str2 = null;
                cAG2.fF(str2);
                hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                cAG2 = com.tencent.mm.plugin.story.g.h.cAG();
                storyGalleryItemView = lVar.sph;
                if (storyGalleryItemView != null) {
                }
                obj = null;
                cAG2.fG(String.valueOf(obj));
                hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                com.tencent.mm.plugin.story.g.h.cAH();
            }
            lVar.spD = lVar.spn;
            AppMethodBeat.o(110850);
        }
    }

    public static final /* synthetic */ void a(l lVar, int i, RecyclerView recyclerView, GalleryHorizontalControlView galleryHorizontalControlView) {
        AppMethodBeat.i(110852);
        ab.i(TAG, "LogStory: onRowSelected " + i + ", " + recyclerView);
        if (!(lVar.rZb == i && a.f.b.j.j(lVar.spi, recyclerView))) {
            Object obj;
            android.support.v7.widget.RecyclerView.i layoutManager;
            android.support.v7.widget.RecyclerView.a adapter;
            com.tencent.mm.plugin.story.g.h hVar;
            lVar.spE = lVar.spt;
            lVar.spD = -1;
            lVar.rZb = i;
            RecyclerView recyclerView2 = lVar.spi;
            com.tencent.mm.plugin.story.ui.b.b bVar = (com.tencent.mm.plugin.story.ui.b.b) (recyclerView2 != null ? recyclerView2.getLayoutManager() : null);
            if (bVar != null) {
                bVar.lqs = null;
            }
            lVar.spi = recyclerView;
            lVar.spj = galleryHorizontalControlView;
            int size = lVar.spr.size();
            int i2 = lVar.rZb;
            if (i2 >= 0 && size > i2) {
                GalleryHorizontalControlView galleryHorizontalControlView2 = lVar.spj;
                if (galleryHorizontalControlView2 != null) {
                    obj = lVar.spr.get(lVar.rZb);
                    a.f.b.j.o(obj, "galleryGroups[selectedRow]");
                    galleryHorizontalControlView2.dI((List) obj);
                }
            }
            recyclerView2 = lVar.spi;
            if (recyclerView2 != null) {
                layoutManager = recyclerView2.getLayoutManager();
            } else {
                layoutManager = null;
            }
            bVar = (com.tencent.mm.plugin.story.ui.b.b) layoutManager;
            if (bVar != null) {
                bVar.lqs = new j(lVar);
            }
            if (bVar != null) {
                bVar.gK(true);
            }
            lVar.spl.i(recyclerView);
            recyclerView2 = lVar.spi;
            if (recyclerView2 != null) {
                adapter = recyclerView2.getAdapter();
            } else {
                adapter = null;
            }
            lVar.spk = (com.tencent.mm.plugin.story.ui.a.g) adapter;
            if (!((ArrayList) lVar.spr.get(i)).isEmpty()) {
                obj = ((ArrayList) lVar.spr.get(i)).get(0);
                a.f.b.j.o(obj, "galleryGroups[row][0]");
                com.tencent.mm.plugin.story.model.d.g gVar = (com.tencent.mm.plugin.story.model.d.g) obj;
                com.tencent.mm.plugin.story.g.h hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                if (!com.tencent.mm.plugin.story.g.h.aaP(gVar.userName)) {
                    hVar2 = com.tencent.mm.plugin.story.g.h.scu;
                    ar cAs = com.tencent.mm.plugin.story.g.h.cAs();
                    cAs.bK(cAs.FI() + 1);
                    if (com.tencent.mm.model.t.mY(gVar.userName)) {
                        hVar = com.tencent.mm.plugin.story.g.h.scu;
                        ar cAs2 = com.tencent.mm.plugin.story.g.h.cAs();
                        cAs2.bL(cAs2.FJ() + 1);
                    }
                }
            }
            hVar = com.tencent.mm.plugin.story.g.h.scu;
            com.tencent.mm.plugin.story.g.h.EX(4);
        }
        AppMethodBeat.o(110852);
    }

    public static final /* synthetic */ void s(l lVar) {
        String string;
        AppMethodBeat.i(110853);
        Object obj = ((ArrayList) lVar.spr.get(lVar.rZb)).get(lVar.spn);
        a.f.b.j.o(obj, "galleryGroups[selectedRow][selectedColumn]");
        com.tencent.mm.plugin.story.model.d.g gVar = (com.tencent.mm.plugin.story.model.d.g) obj;
        com.tencent.mm.plugin.story.model.j.a aVar = com.tencent.mm.plugin.story.model.j.rST;
        com.tencent.mm.plugin.story.h.j Fe = com.tencent.mm.plugin.story.model.j.a.cxT().Fe(gVar.rVZ.cNE);
        if (Fe == null || !Fe.cBW()) {
            string = lVar.getContext().getString(R.string.esh);
        } else {
            string = lVar.getContext().getString(R.string.g_g);
        }
        com.tencent.mm.ui.widget.a.e.a aVar2 = new com.tencent.mm.ui.widget.a.e.a(lVar.getContext());
        aVar2.asL(string).asP(lVar.getContext().getString(R.string.esh)).Qh(-65536).re(true);
        aVar2.c(new h(lVar, Fe)).show();
        ab.i(TAG, "delete click");
        AppMethodBeat.o(110853);
    }

    public static final /* synthetic */ void t(l lVar) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(110855);
        a aVar = lVar.spy;
        if (aVar != null) {
            z = aVar.rvv;
        } else {
            z = false;
        }
        if (!z) {
            com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
            a.f.b.j.o(RP, "MMKernel.storage()");
            if (RP.Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_STORY_EDITOR_SHOW_PRIVACY_TIP_BOOLEAN_SYNC, true)) {
                com.tencent.mm.kernel.e RP2 = com.tencent.mm.kernel.g.RP();
                a.f.b.j.o(RP2, "MMKernel.storage()");
                RP2.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_EDITOR_SHOW_PRIVACY_TIP_BOOLEAN_SYNC, Boolean.FALSE);
                com.tencent.mm.ui.base.h.a(lVar.getContext(), "", lVar.getContext().getString(R.string.g_k), (OnClickListener) new l(lVar));
                AppMethodBeat.o(110855);
                return;
            }
        }
        com.tencent.mm.plugin.story.f.h hVar = lVar.sps;
        if (hVar != null) {
            int i = lVar.rZb;
            int i2 = lVar.spn;
            a aVar2 = lVar.spy;
            if (aVar2 != null) {
                z2 = aVar2.rvv;
            }
            hVar.n(i, i2, z2);
            AppMethodBeat.o(110855);
            return;
        }
        AppMethodBeat.o(110855);
    }

    public static final /* synthetic */ void u(l lVar) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(110856);
        a aVar = lVar.spy;
        if (aVar != null) {
            z = aVar.rYr;
        } else {
            z = false;
        }
        if (!z) {
            com.tencent.mm.kernel.e RP = com.tencent.mm.kernel.g.RP();
            a.f.b.j.o(RP, "MMKernel.storage()");
            if (RP.Ry().getBoolean(com.tencent.mm.storage.ac.a.USERINFO_STORY_EDITOR_SHOW_FAV_TIP_BOOLEAN_SYNC, true)) {
                com.tencent.mm.kernel.e RP2 = com.tencent.mm.kernel.g.RP();
                a.f.b.j.o(RP2, "MMKernel.storage()");
                RP2.Ry().set(com.tencent.mm.storage.ac.a.USERINFO_STORY_EDITOR_SHOW_FAV_TIP_BOOLEAN_SYNC, Boolean.FALSE);
                Context context = lVar.getContext();
                a.f.b.j.o(context, "context");
                com.tencent.mm.ui.base.h.a(lVar.getContext(), "", context.getResources().getString(R.string.g_j), (OnClickListener) new k(lVar));
                AppMethodBeat.o(110856);
                return;
            }
        }
        com.tencent.mm.plugin.story.f.h hVar = lVar.sps;
        if (hVar != null) {
            int i = lVar.rZb;
            int i2 = lVar.spn;
            a aVar2 = lVar.spy;
            if (aVar2 != null) {
                z2 = aVar2.rYr;
            }
            hVar.o(i, i2, z2);
            AppMethodBeat.o(110856);
            return;
        }
        AppMethodBeat.o(110856);
    }
}
