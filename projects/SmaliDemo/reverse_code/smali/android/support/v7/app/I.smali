.class public Landroid/support/v7/app/I;
.super Landroid/support/v7/app/a;
.source ""

# interfaces
.implements Landroid/support/v7/widget/ActionBarOverlayLayout$a;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v7/app/I$a;
    }
.end annotation


# static fields
.field private static final a:Landroid/view/animation/Interpolator;

.field private static final b:Landroid/view/animation/Interpolator;


# instance fields
.field private A:Z

.field B:La/b/d/d/i;

.field private C:Z

.field D:Z

.field final E:La/b/c/g/B;

.field final F:La/b/c/g/B;

.field final G:La/b/c/g/D;

.field c:Landroid/content/Context;

.field private d:Landroid/content/Context;

.field private e:Landroid/app/Activity;

.field private f:Landroid/app/Dialog;

.field g:Landroid/support/v7/widget/ActionBarOverlayLayout;

.field h:Landroid/support/v7/widget/ActionBarContainer;

.field i:Landroid/support/v7/widget/L;

.field j:Landroid/support/v7/widget/ActionBarContextView;

.field k:Landroid/view/View;

.field l:Landroid/support/v7/widget/aa;

.field private m:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private n:I

.field private o:Z

.field p:Landroid/support/v7/app/I$a;

.field q:La/b/d/d/b;

.field r:La/b/d/d/b$a;

.field private s:Z

.field private t:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Landroid/support/v7/app/a$b;",
            ">;"
        }
    .end annotation
.end field

.field private u:Z

.field private v:I

.field w:Z

.field x:Z

.field y:Z

.field private z:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 79
    nop

    .line 84
    new-instance v0, Landroid/view/animation/AccelerateInterpolator;

    invoke-direct {v0}, Landroid/view/animation/AccelerateInterpolator;-><init>()V

    sput-object v0, Landroid/support/v7/app/I;->a:Landroid/view/animation/Interpolator;

    .line 85
    new-instance v0, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v0}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    sput-object v0, Landroid/support/v7/app/I;->b:Landroid/view/animation/Interpolator;

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Z)V
    .locals 3
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "overlayMode"    # Z

    .line 169
    invoke-direct {p0}, Landroid/support/v7/app/a;-><init>()V

    .line 99
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/support/v7/app/I;->m:Ljava/util/ArrayList;

    .line 102
    const/4 v0, -0x1

    iput v0, p0, Landroid/support/v7/app/I;->n:I

    .line 111
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/support/v7/app/I;->t:Ljava/util/ArrayList;

    .line 122
    const/4 v0, 0x0

    iput v0, p0, Landroid/support/v7/app/I;->v:I

    .line 124
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/app/I;->w:Z

    .line 129
    iput-boolean v0, p0, Landroid/support/v7/app/I;->A:Z

    .line 135
    new-instance v0, Landroid/support/v7/app/F;

    invoke-direct {v0, p0}, Landroid/support/v7/app/F;-><init>(Landroid/support/v7/app/I;)V

    iput-object v0, p0, Landroid/support/v7/app/I;->E:La/b/c/g/B;

    .line 152
    new-instance v0, Landroid/support/v7/app/G;

    invoke-direct {v0, p0}, Landroid/support/v7/app/G;-><init>(Landroid/support/v7/app/I;)V

    iput-object v0, p0, Landroid/support/v7/app/I;->F:La/b/c/g/B;

    .line 160
    new-instance v0, Landroid/support/v7/app/H;

    invoke-direct {v0, p0}, Landroid/support/v7/app/H;-><init>(Landroid/support/v7/app/I;)V

    iput-object v0, p0, Landroid/support/v7/app/I;->G:La/b/c/g/D;

    .line 170
    iput-object p1, p0, Landroid/support/v7/app/I;->e:Landroid/app/Activity;

    .line 171
    invoke-virtual {p1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    .line 172
    .local v0, "window":Landroid/view/Window;
    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v1

    .line 173
    .local v1, "decor":Landroid/view/View;
    invoke-direct {p0, v1}, Landroid/support/v7/app/I;->b(Landroid/view/View;)V

    .line 174
    if-nez p2, :cond_0

    .line 175
    const v2, 0x1020002

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    iput-object v2, p0, Landroid/support/v7/app/I;->k:Landroid/view/View;

    .line 177
    :cond_0
    return-void
.end method

.method public constructor <init>(Landroid/app/Dialog;)V
    .locals 1
    .param p1, "dialog"    # Landroid/app/Dialog;

    .line 179
    invoke-direct {p0}, Landroid/support/v7/app/a;-><init>()V

    .line 99
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/support/v7/app/I;->m:Ljava/util/ArrayList;

    .line 102
    const/4 v0, -0x1

    iput v0, p0, Landroid/support/v7/app/I;->n:I

    .line 111
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Landroid/support/v7/app/I;->t:Ljava/util/ArrayList;

    .line 122
    const/4 v0, 0x0

    iput v0, p0, Landroid/support/v7/app/I;->v:I

    .line 124
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/app/I;->w:Z

    .line 129
    iput-boolean v0, p0, Landroid/support/v7/app/I;->A:Z

    .line 135
    new-instance v0, Landroid/support/v7/app/F;

    invoke-direct {v0, p0}, Landroid/support/v7/app/F;-><init>(Landroid/support/v7/app/I;)V

    iput-object v0, p0, Landroid/support/v7/app/I;->E:La/b/c/g/B;

    .line 152
    new-instance v0, Landroid/support/v7/app/G;

    invoke-direct {v0, p0}, Landroid/support/v7/app/G;-><init>(Landroid/support/v7/app/I;)V

    iput-object v0, p0, Landroid/support/v7/app/I;->F:La/b/c/g/B;

    .line 160
    new-instance v0, Landroid/support/v7/app/H;

    invoke-direct {v0, p0}, Landroid/support/v7/app/H;-><init>(Landroid/support/v7/app/I;)V

    iput-object v0, p0, Landroid/support/v7/app/I;->G:La/b/c/g/D;

    .line 180
    iput-object p1, p0, Landroid/support/v7/app/I;->f:Landroid/app/Dialog;

    .line 181
    invoke-virtual {p1}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/support/v7/app/I;->b(Landroid/view/View;)V

    .line 182
    return-void
.end method

.method private a(Landroid/view/View;)Landroid/support/v7/widget/L;
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .line 237
    instance-of v0, p1, Landroid/support/v7/widget/L;

    if-eqz v0, :cond_0

    .line 238
    move-object v0, p1

    check-cast v0, Landroid/support/v7/widget/L;

    return-object v0

    .line 239
    :cond_0
    instance-of v0, p1, Landroid/support/v7/widget/Toolbar;

    if-eqz v0, :cond_1

    .line 240
    move-object v0, p1

    check-cast v0, Landroid/support/v7/widget/Toolbar;

    invoke-virtual {v0}, Landroid/support/v7/widget/Toolbar;->getWrapper()Landroid/support/v7/widget/L;

    move-result-object v0

    return-object v0

    .line 242
    :cond_1
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Can\'t make a decor toolbar out of "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    if-eqz p1, :cond_2

    .line 243
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    :cond_2
    const-string v2, "null"

    :goto_0
    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method static a(ZZZ)Z
    .locals 1
    .param p0, "hiddenByApp"    # Z
    .param p1, "hiddenBySystem"    # Z
    .param p2, "showingForMode"    # Z

    .line 760
    const/4 v0, 0x1

    if-eqz p2, :cond_0

    .line 761
    return v0

    .line 762
    :cond_0
    if-nez p0, :cond_2

    if-eqz p1, :cond_1

    goto :goto_0

    .line 765
    :cond_1
    return v0

    .line 763
    :cond_2
    :goto_0
    const/4 v0, 0x0

    return v0
.end method

.method private b(Landroid/view/View;)V
    .locals 9
    .param p1, "decor"    # Landroid/view/View;

    .line 195
    sget v0, La/b/d/a/f;->decor_content_parent:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/ActionBarOverlayLayout;

    iput-object v0, p0, Landroid/support/v7/app/I;->g:Landroid/support/v7/widget/ActionBarOverlayLayout;

    .line 196
    iget-object v0, p0, Landroid/support/v7/app/I;->g:Landroid/support/v7/widget/ActionBarOverlayLayout;

    if-eqz v0, :cond_0

    .line 197
    invoke-virtual {v0, p0}, Landroid/support/v7/widget/ActionBarOverlayLayout;->setActionBarVisibilityCallback(Landroid/support/v7/widget/ActionBarOverlayLayout$a;)V

    .line 199
    :cond_0
    sget v0, La/b/d/a/f;->action_bar:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-direct {p0, v0}, Landroid/support/v7/app/I;->a(Landroid/view/View;)Landroid/support/v7/widget/L;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v7/app/I;->i:Landroid/support/v7/widget/L;

    .line 200
    sget v0, La/b/d/a/f;->action_context_bar:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/ActionBarContextView;

    iput-object v0, p0, Landroid/support/v7/app/I;->j:Landroid/support/v7/widget/ActionBarContextView;

    .line 202
    sget v0, La/b/d/a/f;->action_bar_container:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/ActionBarContainer;

    iput-object v0, p0, Landroid/support/v7/app/I;->h:Landroid/support/v7/widget/ActionBarContainer;

    .line 205
    iget-object v0, p0, Landroid/support/v7/app/I;->i:Landroid/support/v7/widget/L;

    if-eqz v0, :cond_7

    iget-object v1, p0, Landroid/support/v7/app/I;->j:Landroid/support/v7/widget/ActionBarContextView;

    if-eqz v1, :cond_7

    iget-object v1, p0, Landroid/support/v7/app/I;->h:Landroid/support/v7/widget/ActionBarContainer;

    if-eqz v1, :cond_7

    .line 210
    invoke-interface {v0}, Landroid/support/v7/widget/L;->k()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v7/app/I;->c:Landroid/content/Context;

    .line 213
    iget-object v0, p0, Landroid/support/v7/app/I;->i:Landroid/support/v7/widget/L;

    invoke-interface {v0}, Landroid/support/v7/widget/L;->l()I

    move-result v0

    .line 214
    .local v0, "current":I
    and-int/lit8 v1, v0, 0x4

    const/4 v2, 0x1

    const/4 v3, 0x0

    if-eqz v1, :cond_1

    const/4 v1, 0x1

    goto :goto_0

    :cond_1
    const/4 v1, 0x0

    .line 215
    .local v1, "homeAsUp":Z
    :goto_0
    if-eqz v1, :cond_2

    .line 216
    iput-boolean v2, p0, Landroid/support/v7/app/I;->o:Z

    .line 219
    :cond_2
    iget-object v4, p0, Landroid/support/v7/app/I;->c:Landroid/content/Context;

    invoke-static {v4}, La/b/d/d/a;->a(Landroid/content/Context;)La/b/d/d/a;

    move-result-object v4

    .line 220
    .local v4, "abp":La/b/d/d/a;
    invoke-virtual {v4}, La/b/d/d/a;->a()Z

    move-result v5

    if-nez v5, :cond_4

    if-eqz v1, :cond_3

    goto :goto_1

    :cond_3
    const/4 v5, 0x0

    goto :goto_2

    :cond_4
    :goto_1
    const/4 v5, 0x1

    :goto_2
    invoke-virtual {p0, v5}, Landroid/support/v7/app/I;->j(Z)V

    .line 221
    invoke-virtual {v4}, La/b/d/d/a;->f()Z

    move-result v5

    invoke-direct {p0, v5}, Landroid/support/v7/app/I;->k(Z)V

    .line 223
    iget-object v5, p0, Landroid/support/v7/app/I;->c:Landroid/content/Context;

    const/4 v6, 0x0

    sget-object v7, La/b/d/a/j;->ActionBar:[I

    sget v8, La/b/d/a/a;->actionBarStyle:I

    invoke-virtual {v5, v6, v7, v8, v3}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v5

    .line 226
    .local v5, "a":Landroid/content/res/TypedArray;
    sget v6, La/b/d/a/j;->ActionBar_hideOnContentScroll:I

    invoke-virtual {v5, v6, v3}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v6

    if-eqz v6, :cond_5

    .line 227
    invoke-virtual {p0, v2}, Landroid/support/v7/app/I;->i(Z)V

    .line 229
    :cond_5
    sget v2, La/b/d/a/j;->ActionBar_elevation:I

    invoke-virtual {v5, v2, v3}, Landroid/content/res/TypedArray;->getDimensionPixelSize(II)I

    move-result v2

    .line 230
    .local v2, "elevation":I
    if-eqz v2, :cond_6

    .line 231
    int-to-float v3, v2

    invoke-virtual {p0, v3}, Landroid/support/v7/app/I;->a(F)V

    .line 233
    :cond_6
    invoke-virtual {v5}, Landroid/content/res/TypedArray;->recycle()V

    .line 234
    return-void

    .line 206
    .end local v0    # "current":I
    .end local v1    # "homeAsUp":Z
    .end local v2    # "elevation":I
    .end local v4    # "abp":La/b/d/d/a;
    .end local v5    # "a":Landroid/content/res/TypedArray;
    :cond_7
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, " can only be used "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, "with a compatible window decor layout"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private k(Z)V
    .locals 5
    .param p1, "hasEmbeddedTabs"    # Z

    .line 263
    iput-boolean p1, p0, Landroid/support/v7/app/I;->u:Z

    .line 265
    iget-boolean v0, p0, Landroid/support/v7/app/I;->u:Z

    const/4 v1, 0x0

    if-nez v0, :cond_0

    .line 266
    iget-object v0, p0, Landroid/support/v7/app/I;->i:Landroid/support/v7/widget/L;

    invoke-interface {v0, v1}, Landroid/support/v7/widget/L;->a(Landroid/support/v7/widget/aa;)V

    .line 267
    iget-object v0, p0, Landroid/support/v7/app/I;->h:Landroid/support/v7/widget/ActionBarContainer;

    iget-object v1, p0, Landroid/support/v7/app/I;->l:Landroid/support/v7/widget/aa;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/ActionBarContainer;->setTabContainer(Landroid/support/v7/widget/aa;)V

    goto :goto_0

    .line 269
    :cond_0
    iget-object v0, p0, Landroid/support/v7/app/I;->h:Landroid/support/v7/widget/ActionBarContainer;

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/ActionBarContainer;->setTabContainer(Landroid/support/v7/widget/aa;)V

    .line 270
    iget-object v0, p0, Landroid/support/v7/app/I;->i:Landroid/support/v7/widget/L;

    iget-object v1, p0, Landroid/support/v7/app/I;->l:Landroid/support/v7/widget/aa;

    invoke-interface {v0, v1}, Landroid/support/v7/widget/L;->a(Landroid/support/v7/widget/aa;)V

    .line 272
    :goto_0
    invoke-virtual {p0}, Landroid/support/v7/app/I;->m()I

    move-result v0

    const/4 v1, 0x2

    const/4 v2, 0x1

    const/4 v3, 0x0

    if-ne v0, v1, :cond_1

    const/4 v0, 0x1

    goto :goto_1

    :cond_1
    const/4 v0, 0x0

    .line 273
    .local v0, "isInTabMode":Z
    :goto_1
    iget-object v1, p0, Landroid/support/v7/app/I;->l:Landroid/support/v7/widget/aa;

    if-eqz v1, :cond_3

    .line 274
    if-eqz v0, :cond_2

    .line 275
    invoke-virtual {v1, v3}, Landroid/widget/HorizontalScrollView;->setVisibility(I)V

    .line 276
    iget-object v1, p0, Landroid/support/v7/app/I;->g:Landroid/support/v7/widget/ActionBarOverlayLayout;

    if-eqz v1, :cond_3

    .line 277
    invoke-static {v1}, La/b/c/g/u;->m(Landroid/view/View;)V

    goto :goto_2

    .line 280
    :cond_2
    const/16 v4, 0x8

    invoke-virtual {v1, v4}, Landroid/widget/HorizontalScrollView;->setVisibility(I)V

    .line 283
    :cond_3
    :goto_2
    iget-object v1, p0, Landroid/support/v7/app/I;->i:Landroid/support/v7/widget/L;

    iget-boolean v4, p0, Landroid/support/v7/app/I;->u:Z

    if-nez v4, :cond_4

    if-eqz v0, :cond_4

    const/4 v4, 0x1

    goto :goto_3

    :cond_4
    const/4 v4, 0x0

    :goto_3
    invoke-interface {v1, v4}, Landroid/support/v7/widget/L;->b(Z)V

    .line 284
    iget-object v1, p0, Landroid/support/v7/app/I;->g:Landroid/support/v7/widget/ActionBarOverlayLayout;

    iget-boolean v4, p0, Landroid/support/v7/app/I;->u:Z

    if-nez v4, :cond_5

    if-eqz v0, :cond_5

    goto :goto_4

    :cond_5
    const/4 v2, 0x0

    :goto_4
    invoke-virtual {v1, v2}, Landroid/support/v7/widget/ActionBarOverlayLayout;->setHasNonEmbeddedTabs(Z)V

    .line 285
    return-void
.end method

.method private l(Z)V
    .locals 3
    .param p1, "fromSystem"    # Z

    .line 771
    iget-boolean v0, p0, Landroid/support/v7/app/I;->x:Z

    iget-boolean v1, p0, Landroid/support/v7/app/I;->y:Z

    iget-boolean v2, p0, Landroid/support/v7/app/I;->z:Z

    invoke-static {v0, v1, v2}, Landroid/support/v7/app/I;->a(ZZZ)Z

    move-result v0

    .line 774
    .local v0, "shown":Z
    if-eqz v0, :cond_0

    .line 775
    iget-boolean v1, p0, Landroid/support/v7/app/I;->A:Z

    if-nez v1, :cond_1

    .line 776
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroid/support/v7/app/I;->A:Z

    .line 777
    invoke-virtual {p0, p1}, Landroid/support/v7/app/I;->g(Z)V

    goto :goto_0

    .line 780
    :cond_0
    iget-boolean v1, p0, Landroid/support/v7/app/I;->A:Z

    if-eqz v1, :cond_1

    .line 781
    const/4 v1, 0x0

    iput-boolean v1, p0, Landroid/support/v7/app/I;->A:Z

    .line 782
    invoke-virtual {p0, p1}, Landroid/support/v7/app/I;->f(Z)V

    .line 785
    :cond_1
    :goto_0
    return-void
.end method

.method private n()V
    .locals 2

    .line 712
    iget-boolean v0, p0, Landroid/support/v7/app/I;->z:Z

    if-eqz v0, :cond_1

    .line 713
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v7/app/I;->z:Z

    .line 714
    iget-object v1, p0, Landroid/support/v7/app/I;->g:Landroid/support/v7/widget/ActionBarOverlayLayout;

    if-eqz v1, :cond_0

    .line 715
    invoke-virtual {v1, v0}, Landroid/support/v7/widget/ActionBarOverlayLayout;->setShowingForActionMode(Z)V

    .line 717
    :cond_0
    invoke-direct {p0, v0}, Landroid/support/v7/app/I;->l(Z)V

    .line 719
    :cond_1
    return-void
.end method

.method private o()Z
    .locals 1

    .line 916
    iget-object v0, p0, Landroid/support/v7/app/I;->h:Landroid/support/v7/widget/ActionBarContainer;

    invoke-static {v0}, La/b/c/g/u;->k(Landroid/view/View;)Z

    move-result v0

    return v0
.end method

.method private p()V
    .locals 2

    .line 686
    iget-boolean v0, p0, Landroid/support/v7/app/I;->z:Z

    if-nez v0, :cond_1

    .line 687
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/app/I;->z:Z

    .line 688
    iget-object v1, p0, Landroid/support/v7/app/I;->g:Landroid/support/v7/widget/ActionBarOverlayLayout;

    if-eqz v1, :cond_0

    .line 689
    invoke-virtual {v1, v0}, Landroid/support/v7/widget/ActionBarOverlayLayout;->setShowingForActionMode(Z)V

    .line 691
    :cond_0
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Landroid/support/v7/app/I;->l(Z)V

    .line 693
    :cond_1
    return-void
.end method


# virtual methods
.method public a(La/b/d/d/b$a;)La/b/d/d/b;
    .locals 3
    .param p1, "callback"    # La/b/d/d/b$a;

    .line 523
    iget-object v0, p0, Landroid/support/v7/app/I;->p:Landroid/support/v7/app/I$a;

    if-eqz v0, :cond_0

    .line 524
    invoke-virtual {v0}, Landroid/support/v7/app/I$a;->a()V

    .line 527
    :cond_0
    iget-object v0, p0, Landroid/support/v7/app/I;->g:Landroid/support/v7/widget/ActionBarOverlayLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/ActionBarOverlayLayout;->setHideOnContentScrollEnabled(Z)V

    .line 528
    iget-object v0, p0, Landroid/support/v7/app/I;->j:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0}, Landroid/support/v7/widget/ActionBarContextView;->c()V

    .line 529
    new-instance v0, Landroid/support/v7/app/I$a;

    iget-object v1, p0, Landroid/support/v7/app/I;->j:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v1}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, p0, v1, p1}, Landroid/support/v7/app/I$a;-><init>(Landroid/support/v7/app/I;Landroid/content/Context;La/b/d/d/b$a;)V

    .line 530
    .local v0, "mode":Landroid/support/v7/app/I$a;
    invoke-virtual {v0}, Landroid/support/v7/app/I$a;->k()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 533
    iput-object v0, p0, Landroid/support/v7/app/I;->p:Landroid/support/v7/app/I$a;

    .line 534
    invoke-virtual {v0}, Landroid/support/v7/app/I$a;->i()V

    .line 535
    iget-object v1, p0, Landroid/support/v7/app/I;->j:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v1, v0}, Landroid/support/v7/widget/ActionBarContextView;->a(La/b/d/d/b;)V

    .line 536
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Landroid/support/v7/app/I;->e(Z)V

    .line 537
    iget-object v1, p0, Landroid/support/v7/app/I;->j:Landroid/support/v7/widget/ActionBarContextView;

    const/16 v2, 0x20

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->sendAccessibilityEvent(I)V

    .line 538
    return-object v0

    .line 540
    :cond_1
    const/4 v1, 0x0

    return-object v1
.end method

.method public a()V
    .locals 1

    .line 697
    iget-boolean v0, p0, Landroid/support/v7/app/I;->y:Z

    if-eqz v0, :cond_0

    .line 698
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v7/app/I;->y:Z

    .line 699
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Landroid/support/v7/app/I;->l(Z)V

    .line 701
    :cond_0
    return-void
.end method

.method public a(F)V
    .locals 1
    .param p1, "elevation"    # F

    .line 249
    iget-object v0, p0, Landroid/support/v7/app/I;->h:Landroid/support/v7/widget/ActionBarContainer;

    invoke-static {v0, p1}, La/b/c/g/u;->a(Landroid/view/View;F)V

    .line 250
    return-void
.end method

.method public a(I)V
    .locals 0
    .param p1, "visibility"    # I

    .line 321
    iput p1, p0, Landroid/support/v7/app/I;->v:I

    .line 322
    return-void
.end method

.method public a(II)V
    .locals 4
    .param p1, "options"    # I
    .param p2, "mask"    # I

    .line 474
    iget-object v0, p0, Landroid/support/v7/app/I;->i:Landroid/support/v7/widget/L;

    invoke-interface {v0}, Landroid/support/v7/widget/L;->l()I

    move-result v0

    .line 475
    .local v0, "current":I
    and-int/lit8 v1, p2, 0x4

    if-eqz v1, :cond_0

    .line 476
    const/4 v1, 0x1

    iput-boolean v1, p0, Landroid/support/v7/app/I;->o:Z

    .line 478
    :cond_0
    iget-object v1, p0, Landroid/support/v7/app/I;->i:Landroid/support/v7/widget/L;

    and-int v2, p1, p2

    xor-int/lit8 v3, p2, -0x1

    and-int/2addr v3, v0

    or-int/2addr v2, v3

    invoke-interface {v1, v2}, Landroid/support/v7/widget/L;->a(I)V

    .line 479
    return-void
.end method

.method public a(Landroid/content/res/Configuration;)V
    .locals 1
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .line 259
    iget-object v0, p0, Landroid/support/v7/app/I;->c:Landroid/content/Context;

    invoke-static {v0}, La/b/d/d/a;->a(Landroid/content/Context;)La/b/d/d/a;

    move-result-object v0

    invoke-virtual {v0}, La/b/d/d/a;->f()Z

    move-result v0

    invoke-direct {p0, v0}, Landroid/support/v7/app/I;->k(Z)V

    .line 260
    return-void
.end method

.method public a(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "title"    # Ljava/lang/CharSequence;

    .line 446
    iget-object v0, p0, Landroid/support/v7/app/I;->i:Landroid/support/v7/widget/L;

    invoke-interface {v0, p1}, Landroid/support/v7/widget/L;->setWindowTitle(Ljava/lang/CharSequence;)V

    .line 447
    return-void
.end method

.method public a(Z)V
    .locals 0
    .param p1, "enabled"    # Z

    .line 674
    iput-boolean p1, p0, Landroid/support/v7/app/I;->w:Z

    .line 675
    return-void
.end method

.method public a(ILandroid/view/KeyEvent;)Z
    .locals 5
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .line 1402
    iget-object v0, p0, Landroid/support/v7/app/I;->p:Landroid/support/v7/app/I$a;

    const/4 v1, 0x0

    if-nez v0, :cond_0

    .line 1403
    return v1

    .line 1405
    :cond_0
    invoke-virtual {v0}, Landroid/support/v7/app/I$a;->c()Landroid/view/Menu;

    move-result-object v0

    .line 1406
    .local v0, "menu":Landroid/view/Menu;
    if-eqz v0, :cond_3

    .line 1407
    if-eqz p2, :cond_1

    .line 1408
    invoke-virtual {p2}, Landroid/view/KeyEvent;->getDeviceId()I

    move-result v2

    goto :goto_0

    :cond_1
    const/4 v2, -0x1

    .line 1407
    :goto_0
    invoke-static {v2}, Landroid/view/KeyCharacterMap;->load(I)Landroid/view/KeyCharacterMap;

    move-result-object v2

    .line 1409
    .local v2, "kmap":Landroid/view/KeyCharacterMap;
    invoke-virtual {v2}, Landroid/view/KeyCharacterMap;->getKeyboardType()I

    move-result v3

    const/4 v4, 0x1

    if-eq v3, v4, :cond_2

    goto :goto_1

    :cond_2
    const/4 v4, 0x0

    :goto_1
    invoke-interface {v0, v4}, Landroid/view/Menu;->setQwertyMode(Z)V

    .line 1410
    invoke-interface {v0, p1, p2, v1}, Landroid/view/Menu;->performShortcut(ILandroid/view/KeyEvent;I)Z

    move-result v1

    return v1

    .line 1412
    .end local v2    # "kmap":Landroid/view/KeyCharacterMap;
    :cond_3
    return v1
.end method

.method public b()V
    .locals 0

    .line 971
    return-void
.end method

.method public b(Z)V
    .locals 3
    .param p1, "isVisible"    # Z

    .line 351
    iget-boolean v0, p0, Landroid/support/v7/app/I;->s:Z

    if-ne p1, v0, :cond_0

    .line 352
    return-void

    .line 354
    :cond_0
    iput-boolean p1, p0, Landroid/support/v7/app/I;->s:Z

    .line 356
    iget-object v0, p0, Landroid/support/v7/app/I;->t:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 357
    .local v0, "count":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v0, :cond_1

    .line 358
    iget-object v2, p0, Landroid/support/v7/app/I;->t:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/support/v7/app/a$b;

    invoke-interface {v2, p1}, Landroid/support/v7/app/a$b;->onMenuVisibilityChanged(Z)V

    .line 357
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 360
    .end local v1    # "i":I
    :cond_1
    return-void
.end method

.method public c()V
    .locals 1

    .line 723
    iget-boolean v0, p0, Landroid/support/v7/app/I;->y:Z

    if-nez v0, :cond_0

    .line 724
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/app/I;->y:Z

    .line 725
    invoke-direct {p0, v0}, Landroid/support/v7/app/I;->l(Z)V

    .line 727
    :cond_0
    return-void
.end method

.method public c(Z)V
    .locals 1
    .param p1, "enable"    # Z

    .line 1395
    iget-boolean v0, p0, Landroid/support/v7/app/I;->o:Z

    if-nez v0, :cond_0

    .line 1396
    invoke-virtual {p0, p1}, Landroid/support/v7/app/I;->h(Z)V

    .line 1398
    :cond_0
    return-void
.end method

.method public d()V
    .locals 1

    .line 963
    iget-object v0, p0, Landroid/support/v7/app/I;->B:La/b/d/d/i;

    if-eqz v0, :cond_0

    .line 964
    invoke-virtual {v0}, La/b/d/d/i;->a()V

    .line 965
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v7/app/I;->B:La/b/d/d/i;

    .line 967
    :cond_0
    return-void
.end method

.method public d(Z)V
    .locals 1
    .param p1, "enabled"    # Z

    .line 333
    iput-boolean p1, p0, Landroid/support/v7/app/I;->C:Z

    .line 334
    if-nez p1, :cond_0

    iget-object v0, p0, Landroid/support/v7/app/I;->B:La/b/d/d/i;

    if-eqz v0, :cond_0

    .line 335
    invoke-virtual {v0}, La/b/d/d/i;->a()V

    .line 337
    :cond_0
    return-void
.end method

.method public e(Z)V
    .locals 8
    .param p1, "toActionMode"    # Z

    .line 875
    if-eqz p1, :cond_0

    .line 876
    invoke-direct {p0}, Landroid/support/v7/app/I;->p()V

    goto :goto_0

    .line 878
    :cond_0
    invoke-direct {p0}, Landroid/support/v7/app/I;->n()V

    .line 881
    :goto_0
    invoke-direct {p0}, Landroid/support/v7/app/I;->o()Z

    move-result v0

    const/4 v1, 0x4

    const/16 v2, 0x8

    const/4 v3, 0x0

    if-eqz v0, :cond_2

    .line 883
    const-wide/16 v4, 0x64

    const-wide/16 v6, 0xc8

    if-eqz p1, :cond_1

    .line 888
    iget-object v0, p0, Landroid/support/v7/app/I;->i:Landroid/support/v7/widget/L;

    invoke-interface {v0, v1, v4, v5}, Landroid/support/v7/widget/L;->a(IJ)La/b/c/g/A;

    move-result-object v0

    .line 890
    .local v0, "fadeOut":La/b/c/g/A;
    iget-object v1, p0, Landroid/support/v7/app/I;->j:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v1, v3, v6, v7}, Landroid/support/v7/widget/ActionBarContextView;->a(IJ)La/b/c/g/A;

    move-result-object v1

    .local v1, "fadeIn":La/b/c/g/A;
    goto :goto_1

    .line 893
    .end local v0    # "fadeOut":La/b/c/g/A;
    .end local v1    # "fadeIn":La/b/c/g/A;
    :cond_1
    iget-object v0, p0, Landroid/support/v7/app/I;->i:Landroid/support/v7/widget/L;

    invoke-interface {v0, v3, v6, v7}, Landroid/support/v7/widget/L;->a(IJ)La/b/c/g/A;

    move-result-object v1

    .line 895
    .restart local v1    # "fadeIn":La/b/c/g/A;
    iget-object v0, p0, Landroid/support/v7/app/I;->j:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0, v2, v4, v5}, Landroid/support/v7/widget/ActionBarContextView;->a(IJ)La/b/c/g/A;

    move-result-object v0

    .line 898
    .restart local v0    # "fadeOut":La/b/c/g/A;
    :goto_1
    new-instance v2, La/b/d/d/i;

    invoke-direct {v2}, La/b/d/d/i;-><init>()V

    .line 899
    .local v2, "set":La/b/d/d/i;
    invoke-virtual {v2, v0, v1}, La/b/d/d/i;->a(La/b/c/g/A;La/b/c/g/A;)La/b/d/d/i;

    .line 900
    invoke-virtual {v2}, La/b/d/d/i;->c()V

    .line 901
    .end local v0    # "fadeOut":La/b/c/g/A;
    .end local v1    # "fadeIn":La/b/c/g/A;
    .end local v2    # "set":La/b/d/d/i;
    goto :goto_2

    .line 902
    :cond_2
    if-eqz p1, :cond_3

    .line 903
    iget-object v0, p0, Landroid/support/v7/app/I;->i:Landroid/support/v7/widget/L;

    invoke-interface {v0, v1}, Landroid/support/v7/widget/L;->c(I)V

    .line 904
    iget-object v0, p0, Landroid/support/v7/app/I;->j:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0, v3}, Landroid/support/v7/widget/ActionBarContextView;->setVisibility(I)V

    goto :goto_2

    .line 906
    :cond_3
    iget-object v0, p0, Landroid/support/v7/app/I;->i:Landroid/support/v7/widget/L;

    invoke-interface {v0, v3}, Landroid/support/v7/widget/L;->c(I)V

    .line 907
    iget-object v0, p0, Landroid/support/v7/app/I;->j:Landroid/support/v7/widget/ActionBarContextView;

    invoke-virtual {v0, v2}, Landroid/support/v7/widget/ActionBarContextView;->setVisibility(I)V

    .line 911
    :goto_2
    return-void
.end method

.method public f(Z)V
    .locals 5
    .param p1, "fromSystem"    # Z

    .line 837
    iget-object v0, p0, Landroid/support/v7/app/I;->B:La/b/d/d/i;

    if-eqz v0, :cond_0

    .line 838
    invoke-virtual {v0}, La/b/d/d/i;->a()V

    .line 841
    :cond_0
    iget v0, p0, Landroid/support/v7/app/I;->v:I

    if-nez v0, :cond_4

    iget-boolean v0, p0, Landroid/support/v7/app/I;->C:Z

    if-nez v0, :cond_1

    if-eqz p1, :cond_4

    .line 842
    :cond_1
    iget-object v0, p0, Landroid/support/v7/app/I;->h:Landroid/support/v7/widget/ActionBarContainer;

    const/high16 v1, 0x3f800000    # 1.0f

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->setAlpha(F)V

    .line 843
    iget-object v0, p0, Landroid/support/v7/app/I;->h:Landroid/support/v7/widget/ActionBarContainer;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/ActionBarContainer;->setTransitioning(Z)V

    .line 844
    new-instance v0, La/b/d/d/i;

    invoke-direct {v0}, La/b/d/d/i;-><init>()V

    .line 845
    .local v0, "anim":La/b/d/d/i;
    iget-object v2, p0, Landroid/support/v7/app/I;->h:Landroid/support/v7/widget/ActionBarContainer;

    invoke-virtual {v2}, Landroid/widget/FrameLayout;->getHeight()I

    move-result v2

    neg-int v2, v2

    int-to-float v2, v2

    .line 846
    .local v2, "endingY":F
    if-eqz p1, :cond_2

    .line 847
    const/4 v3, 0x2

    new-array v3, v3, [I

    fill-array-data v3, :array_0

    .line 848
    .local v3, "topLeft":[I
    iget-object v4, p0, Landroid/support/v7/app/I;->h:Landroid/support/v7/widget/ActionBarContainer;

    invoke-virtual {v4, v3}, Landroid/widget/FrameLayout;->getLocationInWindow([I)V

    .line 849
    aget v1, v3, v1

    int-to-float v1, v1

    sub-float/2addr v2, v1

    .line 851
    .end local v3    # "topLeft":[I
    :cond_2
    iget-object v1, p0, Landroid/support/v7/app/I;->h:Landroid/support/v7/widget/ActionBarContainer;

    invoke-static {v1}, La/b/c/g/u;->a(Landroid/view/View;)La/b/c/g/A;

    move-result-object v1

    invoke-virtual {v1, v2}, La/b/c/g/A;->b(F)La/b/c/g/A;

    move-result-object v1

    .line 852
    .local v1, "a":La/b/c/g/A;
    iget-object v3, p0, Landroid/support/v7/app/I;->G:La/b/c/g/D;

    invoke-virtual {v1, v3}, La/b/c/g/A;->a(La/b/c/g/D;)La/b/c/g/A;

    .line 853
    invoke-virtual {v0, v1}, La/b/d/d/i;->a(La/b/c/g/A;)La/b/d/d/i;

    .line 854
    iget-boolean v3, p0, Landroid/support/v7/app/I;->w:Z

    if-eqz v3, :cond_3

    iget-object v3, p0, Landroid/support/v7/app/I;->k:Landroid/view/View;

    if-eqz v3, :cond_3

    .line 855
    invoke-static {v3}, La/b/c/g/u;->a(Landroid/view/View;)La/b/c/g/A;

    move-result-object v3

    invoke-virtual {v3, v2}, La/b/c/g/A;->b(F)La/b/c/g/A;

    invoke-virtual {v0, v3}, La/b/d/d/i;->a(La/b/c/g/A;)La/b/d/d/i;

    .line 857
    :cond_3
    sget-object v3, Landroid/support/v7/app/I;->a:Landroid/view/animation/Interpolator;

    invoke-virtual {v0, v3}, La/b/d/d/i;->a(Landroid/view/animation/Interpolator;)La/b/d/d/i;

    .line 858
    const-wide/16 v3, 0xfa

    invoke-virtual {v0, v3, v4}, La/b/d/d/i;->a(J)La/b/d/d/i;

    .line 859
    iget-object v3, p0, Landroid/support/v7/app/I;->E:La/b/c/g/B;

    invoke-virtual {v0, v3}, La/b/d/d/i;->a(La/b/c/g/B;)La/b/d/d/i;

    .line 860
    iput-object v0, p0, Landroid/support/v7/app/I;->B:La/b/d/d/i;

    .line 861
    invoke-virtual {v0}, La/b/d/d/i;->c()V

    .line 862
    .end local v0    # "anim":La/b/d/d/i;
    .end local v1    # "a":La/b/c/g/A;
    .end local v2    # "endingY":F
    goto :goto_0

    .line 863
    :cond_4
    iget-object v0, p0, Landroid/support/v7/app/I;->E:La/b/c/g/B;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, La/b/c/g/B;->b(Landroid/view/View;)V

    .line 865
    :goto_0
    return-void

    :array_0
    .array-data 4
        0x0
        0x0
    .end array-data
.end method

.method public f()Z
    .locals 1

    .line 975
    iget-object v0, p0, Landroid/support/v7/app/I;->i:Landroid/support/v7/widget/L;

    if-eqz v0, :cond_0

    invoke-interface {v0}, Landroid/support/v7/widget/L;->h()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 976
    iget-object v0, p0, Landroid/support/v7/app/I;->i:Landroid/support/v7/widget/L;

    invoke-interface {v0}, Landroid/support/v7/widget/L;->collapseActionView()V

    .line 977
    const/4 v0, 0x1

    return v0

    .line 979
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public g()I
    .locals 1

    .line 518
    iget-object v0, p0, Landroid/support/v7/app/I;->i:Landroid/support/v7/widget/L;

    invoke-interface {v0}, Landroid/support/v7/widget/L;->l()I

    move-result v0

    return v0
.end method

.method public g(Z)V
    .locals 6
    .param p1, "fromSystem"    # Z

    .line 788
    iget-object v0, p0, Landroid/support/v7/app/I;->B:La/b/d/d/i;

    if-eqz v0, :cond_0

    .line 789
    invoke-virtual {v0}, La/b/d/d/i;->a()V

    .line 791
    :cond_0
    iget-object v0, p0, Landroid/support/v7/app/I;->h:Landroid/support/v7/widget/ActionBarContainer;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v7/widget/ActionBarContainer;->setVisibility(I)V

    .line 793
    iget v0, p0, Landroid/support/v7/app/I;->v:I

    const/4 v1, 0x0

    if-nez v0, :cond_4

    iget-boolean v0, p0, Landroid/support/v7/app/I;->C:Z

    if-nez v0, :cond_1

    if-eqz p1, :cond_4

    .line 795
    :cond_1
    iget-object v0, p0, Landroid/support/v7/app/I;->h:Landroid/support/v7/widget/ActionBarContainer;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->setTranslationY(F)V

    .line 796
    iget-object v0, p0, Landroid/support/v7/app/I;->h:Landroid/support/v7/widget/ActionBarContainer;

    invoke-virtual {v0}, Landroid/widget/FrameLayout;->getHeight()I

    move-result v0

    neg-int v0, v0

    int-to-float v0, v0

    .line 797
    .local v0, "startingY":F
    if-eqz p1, :cond_2

    .line 798
    const/4 v2, 0x2

    new-array v2, v2, [I

    fill-array-data v2, :array_0

    .line 799
    .local v2, "topLeft":[I
    iget-object v3, p0, Landroid/support/v7/app/I;->h:Landroid/support/v7/widget/ActionBarContainer;

    invoke-virtual {v3, v2}, Landroid/widget/FrameLayout;->getLocationInWindow([I)V

    .line 800
    const/4 v3, 0x1

    aget v3, v2, v3

    int-to-float v3, v3

    sub-float/2addr v0, v3

    .line 802
    .end local v2    # "topLeft":[I
    :cond_2
    iget-object v2, p0, Landroid/support/v7/app/I;->h:Landroid/support/v7/widget/ActionBarContainer;

    invoke-virtual {v2, v0}, Landroid/widget/FrameLayout;->setTranslationY(F)V

    .line 803
    new-instance v2, La/b/d/d/i;

    invoke-direct {v2}, La/b/d/d/i;-><init>()V

    .line 804
    .local v2, "anim":La/b/d/d/i;
    iget-object v3, p0, Landroid/support/v7/app/I;->h:Landroid/support/v7/widget/ActionBarContainer;

    invoke-static {v3}, La/b/c/g/u;->a(Landroid/view/View;)La/b/c/g/A;

    move-result-object v3

    invoke-virtual {v3, v1}, La/b/c/g/A;->b(F)La/b/c/g/A;

    move-result-object v3

    .line 805
    .local v3, "a":La/b/c/g/A;
    iget-object v4, p0, Landroid/support/v7/app/I;->G:La/b/c/g/D;

    invoke-virtual {v3, v4}, La/b/c/g/A;->a(La/b/c/g/D;)La/b/c/g/A;

    .line 806
    invoke-virtual {v2, v3}, La/b/d/d/i;->a(La/b/c/g/A;)La/b/d/d/i;

    .line 807
    iget-boolean v4, p0, Landroid/support/v7/app/I;->w:Z

    if-eqz v4, :cond_3

    iget-object v4, p0, Landroid/support/v7/app/I;->k:Landroid/view/View;

    if-eqz v4, :cond_3

    .line 808
    invoke-virtual {v4, v0}, Landroid/view/View;->setTranslationY(F)V

    .line 809
    iget-object v4, p0, Landroid/support/v7/app/I;->k:Landroid/view/View;

    invoke-static {v4}, La/b/c/g/u;->a(Landroid/view/View;)La/b/c/g/A;

    move-result-object v4

    invoke-virtual {v4, v1}, La/b/c/g/A;->b(F)La/b/c/g/A;

    invoke-virtual {v2, v4}, La/b/d/d/i;->a(La/b/c/g/A;)La/b/d/d/i;

    .line 811
    :cond_3
    sget-object v1, Landroid/support/v7/app/I;->b:Landroid/view/animation/Interpolator;

    invoke-virtual {v2, v1}, La/b/d/d/i;->a(Landroid/view/animation/Interpolator;)La/b/d/d/i;

    .line 812
    const-wide/16 v4, 0xfa

    invoke-virtual {v2, v4, v5}, La/b/d/d/i;->a(J)La/b/d/d/i;

    .line 820
    iget-object v1, p0, Landroid/support/v7/app/I;->F:La/b/c/g/B;

    invoke-virtual {v2, v1}, La/b/d/d/i;->a(La/b/c/g/B;)La/b/d/d/i;

    .line 821
    iput-object v2, p0, Landroid/support/v7/app/I;->B:La/b/d/d/i;

    .line 822
    invoke-virtual {v2}, La/b/d/d/i;->c()V

    .line 823
    .end local v0    # "startingY":F
    .end local v2    # "anim":La/b/d/d/i;
    .end local v3    # "a":La/b/c/g/A;
    goto :goto_0

    .line 824
    :cond_4
    iget-object v0, p0, Landroid/support/v7/app/I;->h:Landroid/support/v7/widget/ActionBarContainer;

    const/high16 v2, 0x3f800000    # 1.0f

    invoke-virtual {v0, v2}, Landroid/widget/FrameLayout;->setAlpha(F)V

    .line 825
    iget-object v0, p0, Landroid/support/v7/app/I;->h:Landroid/support/v7/widget/ActionBarContainer;

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->setTranslationY(F)V

    .line 826
    iget-boolean v0, p0, Landroid/support/v7/app/I;->w:Z

    if-eqz v0, :cond_5

    iget-object v0, p0, Landroid/support/v7/app/I;->k:Landroid/view/View;

    if-eqz v0, :cond_5

    .line 827
    invoke-virtual {v0, v1}, Landroid/view/View;->setTranslationY(F)V

    .line 829
    :cond_5
    iget-object v0, p0, Landroid/support/v7/app/I;->F:La/b/c/g/B;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, La/b/c/g/B;->b(Landroid/view/View;)V

    .line 831
    :goto_0
    iget-object v0, p0, Landroid/support/v7/app/I;->g:Landroid/support/v7/widget/ActionBarOverlayLayout;

    if-eqz v0, :cond_6

    .line 832
    invoke-static {v0}, La/b/c/g/u;->m(Landroid/view/View;)V

    .line 834
    :cond_6
    return-void

    :array_0
    .array-data 4
        0x0
        0x0
    .end array-data
.end method

.method public h()Landroid/content/Context;
    .locals 5

    .line 921
    iget-object v0, p0, Landroid/support/v7/app/I;->d:Landroid/content/Context;

    if-nez v0, :cond_1

    .line 922
    new-instance v0, Landroid/util/TypedValue;

    invoke-direct {v0}, Landroid/util/TypedValue;-><init>()V

    .line 923
    .local v0, "outValue":Landroid/util/TypedValue;
    iget-object v1, p0, Landroid/support/v7/app/I;->c:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v1

    .line 924
    .local v1, "currentTheme":Landroid/content/res/Resources$Theme;
    sget v2, La/b/d/a/a;->actionBarWidgetTheme:I

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v0, v3}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    .line 925
    iget v2, v0, Landroid/util/TypedValue;->resourceId:I

    .line 927
    .local v2, "targetThemeRes":I
    if-eqz v2, :cond_0

    .line 928
    new-instance v3, Landroid/view/ContextThemeWrapper;

    iget-object v4, p0, Landroid/support/v7/app/I;->c:Landroid/content/Context;

    invoke-direct {v3, v4, v2}, Landroid/view/ContextThemeWrapper;-><init>(Landroid/content/Context;I)V

    iput-object v3, p0, Landroid/support/v7/app/I;->d:Landroid/content/Context;

    goto :goto_0

    .line 930
    :cond_0
    iget-object v3, p0, Landroid/support/v7/app/I;->c:Landroid/content/Context;

    iput-object v3, p0, Landroid/support/v7/app/I;->d:Landroid/content/Context;

    .line 933
    .end local v0    # "outValue":Landroid/util/TypedValue;
    .end local v1    # "currentTheme":Landroid/content/res/Resources$Theme;
    .end local v2    # "targetThemeRes":I
    :cond_1
    :goto_0
    iget-object v0, p0, Landroid/support/v7/app/I;->d:Landroid/content/Context;

    return-object v0
.end method

.method public h(Z)V
    .locals 2
    .param p1, "showHomeAsUp"    # Z

    .line 380
    const/4 v0, 0x4

    if-eqz p1, :cond_0

    const/4 v1, 0x4

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :goto_0
    invoke-virtual {p0, v1, v0}, Landroid/support/v7/app/I;->a(II)V

    .line 381
    return-void
.end method

.method public i(Z)V
    .locals 2
    .param p1, "hideOnContentScroll"    # Z

    .line 731
    if-eqz p1, :cond_1

    iget-object v0, p0, Landroid/support/v7/app/I;->g:Landroid/support/v7/widget/ActionBarOverlayLayout;

    invoke-virtual {v0}, Landroid/support/v7/widget/ActionBarOverlayLayout;->i()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    .line 732
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 735
    :cond_1
    :goto_0
    iput-boolean p1, p0, Landroid/support/v7/app/I;->D:Z

    .line 736
    iget-object v0, p0, Landroid/support/v7/app/I;->g:Landroid/support/v7/widget/ActionBarOverlayLayout;

    invoke-virtual {v0, p1}, Landroid/support/v7/widget/ActionBarOverlayLayout;->setHideOnContentScrollEnabled(Z)V

    .line 737
    return-void
.end method

.method public j(Z)V
    .locals 1
    .param p1, "enable"    # Z

    .line 395
    iget-object v0, p0, Landroid/support/v7/app/I;->i:Landroid/support/v7/widget/L;

    invoke-interface {v0, p1}, Landroid/support/v7/widget/L;->a(Z)V

    .line 396
    return-void
.end method

.method l()V
    .locals 2

    .line 312
    iget-object v0, p0, Landroid/support/v7/app/I;->r:La/b/d/d/b$a;

    if-eqz v0, :cond_0

    .line 313
    iget-object v1, p0, Landroid/support/v7/app/I;->q:La/b/d/d/b;

    invoke-interface {v0, v1}, La/b/d/d/b$a;->a(La/b/d/d/b;)V

    .line 314
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v7/app/I;->q:La/b/d/d/b;

    .line 315
    iput-object v0, p0, Landroid/support/v7/app/I;->r:La/b/d/d/b$a;

    .line 317
    :cond_0
    return-void
.end method

.method public m()I
    .locals 1

    .line 513
    iget-object v0, p0, Landroid/support/v7/app/I;->i:Landroid/support/v7/widget/L;

    invoke-interface {v0}, Landroid/support/v7/widget/L;->i()I

    move-result v0

    return v0
.end method
