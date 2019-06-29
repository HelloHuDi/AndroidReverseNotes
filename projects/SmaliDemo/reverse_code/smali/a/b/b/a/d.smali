.class public La/b/b/a/d;
.super La/b/b/a/i;
.source ""

# interfaces
.implements La/b/b/a/b;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        La/b/b/a/d$a;,
        La/b/b/a/d$b;
    }
.end annotation


# instance fields
.field private b:La/b/b/a/d$a;

.field private c:Landroid/content/Context;

.field private d:Landroid/animation/ArgbEvaluator;

.field private e:Landroid/animation/Animator$AnimatorListener;

.field f:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field final g:Landroid/graphics/drawable/Drawable$Callback;


# direct methods
.method constructor <init>()V
    .locals 1

    .line 168
    const/4 v0, 0x0

    invoke-direct {p0, v0, v0, v0}, La/b/b/a/d;-><init>(Landroid/content/Context;La/b/b/a/d$a;Landroid/content/res/Resources;)V

    .line 169
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .line 172
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, v0}, La/b/b/a/d;-><init>(Landroid/content/Context;La/b/b/a/d$a;Landroid/content/res/Resources;)V

    .line 173
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;La/b/b/a/d$a;Landroid/content/res/Resources;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "state"    # La/b/b/a/d$a;
    .param p3, "res"    # Landroid/content/res/Resources;

    .line 177
    invoke-direct {p0}, La/b/b/a/i;-><init>()V

    .line 156
    const/4 v0, 0x0

    iput-object v0, p0, La/b/b/a/d;->d:Landroid/animation/ArgbEvaluator;

    .line 161
    iput-object v0, p0, La/b/b/a/d;->e:Landroid/animation/Animator$AnimatorListener;

    .line 164
    iput-object v0, p0, La/b/b/a/d;->f:Ljava/util/ArrayList;

    .line 723
    new-instance v0, La/b/b/a/c;

    invoke-direct {v0, p0}, La/b/b/a/c;-><init>(La/b/b/a/d;)V

    iput-object v0, p0, La/b/b/a/d;->g:Landroid/graphics/drawable/Drawable$Callback;

    .line 178
    iput-object p1, p0, La/b/b/a/d;->c:Landroid/content/Context;

    .line 179
    if-eqz p2, :cond_0

    .line 180
    iput-object p2, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    goto :goto_0

    .line 182
    :cond_0
    new-instance v0, La/b/b/a/d$a;

    iget-object v1, p0, La/b/b/a/d;->g:Landroid/graphics/drawable/Drawable$Callback;

    invoke-direct {v0, p1, p2, v1, p3}, La/b/b/a/d$a;-><init>(Landroid/content/Context;La/b/b/a/d$a;Landroid/graphics/drawable/Drawable$Callback;Landroid/content/res/Resources;)V

    iput-object v0, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    .line 185
    :goto_0
    return-void
.end method

.method public static a(Landroid/content/Context;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)La/b/b/a/d;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "r"    # Landroid/content/res/Resources;
    .param p2, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .param p3, "attrs"    # Landroid/util/AttributeSet;
    .param p4, "theme"    # Landroid/content/res/Resources$Theme;

    .line 253
    new-instance v0, La/b/b/a/d;

    invoke-direct {v0, p0}, La/b/b/a/d;-><init>(Landroid/content/Context;)V

    .line 254
    .local v0, "drawable":La/b/b/a/d;
    invoke-virtual {v0, p1, p2, p3, p4}, La/b/b/a/d;->inflate(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)V

    .line 255
    return-object v0
.end method

.method private a(Landroid/animation/Animator;)V
    .locals 3
    .param p1, "animator"    # Landroid/animation/Animator;

    .line 651
    instance-of v0, p1, Landroid/animation/AnimatorSet;

    if-eqz v0, :cond_0

    .line 652
    move-object v0, p1

    check-cast v0, Landroid/animation/AnimatorSet;

    invoke-virtual {v0}, Landroid/animation/AnimatorSet;->getChildAnimations()Ljava/util/ArrayList;

    move-result-object v0

    .line 653
    .local v0, "childAnimators":Ljava/util/List;, "Ljava/util/List<Landroid/animation/Animator;>;"
    if-eqz v0, :cond_0

    .line 654
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 655
    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/animation/Animator;

    invoke-direct {p0, v2}, La/b/b/a/d;->a(Landroid/animation/Animator;)V

    .line 654
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 659
    .end local v0    # "childAnimators":Ljava/util/List;, "Ljava/util/List<Landroid/animation/Animator;>;"
    .end local v1    # "i":I
    :cond_0
    instance-of v0, p1, Landroid/animation/ObjectAnimator;

    if-eqz v0, :cond_3

    .line 660
    move-object v0, p1

    check-cast v0, Landroid/animation/ObjectAnimator;

    .line 661
    .local v0, "objectAnim":Landroid/animation/ObjectAnimator;
    invoke-virtual {v0}, Landroid/animation/ObjectAnimator;->getPropertyName()Ljava/lang/String;

    move-result-object v1

    .line 662
    .local v1, "propertyName":Ljava/lang/String;
    const-string v2, "fillColor"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    const-string v2, "strokeColor"

    invoke-virtual {v2, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 663
    :cond_1
    iget-object v2, p0, La/b/b/a/d;->d:Landroid/animation/ArgbEvaluator;

    if-nez v2, :cond_2

    .line 664
    new-instance v2, Landroid/animation/ArgbEvaluator;

    invoke-direct {v2}, Landroid/animation/ArgbEvaluator;-><init>()V

    iput-object v2, p0, La/b/b/a/d;->d:Landroid/animation/ArgbEvaluator;

    .line 666
    :cond_2
    iget-object v2, p0, La/b/b/a/d;->d:Landroid/animation/ArgbEvaluator;

    invoke-virtual {v0, v2}, Landroid/animation/ObjectAnimator;->setEvaluator(Landroid/animation/TypeEvaluator;)V

    .line 669
    .end local v0    # "objectAnim":Landroid/animation/ObjectAnimator;
    .end local v1    # "propertyName":Ljava/lang/String;
    :cond_3
    return-void
.end method

.method private a(Ljava/lang/String;Landroid/animation/Animator;)V
    .locals 3
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "animator"    # Landroid/animation/Animator;

    .line 672
    iget-object v0, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v0, v0, La/b/b/a/d$a;->b:La/b/b/a/k;

    invoke-virtual {v0, p1}, La/b/b/a/k;->a(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 673
    .local v0, "target":Ljava/lang/Object;
    invoke-virtual {p2, v0}, Landroid/animation/Animator;->setTarget(Ljava/lang/Object;)V

    .line 674
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x15

    if-ge v1, v2, :cond_0

    .line 675
    invoke-direct {p0, p2}, La/b/b/a/d;->a(Landroid/animation/Animator;)V

    .line 677
    :cond_0
    iget-object v1, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v2, v1, La/b/b/a/d$a;->d:Ljava/util/ArrayList;

    if-nez v2, :cond_1

    .line 678
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, v1, La/b/b/a/d$a;->d:Ljava/util/ArrayList;

    .line 679
    iget-object v1, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    new-instance v2, La/b/c/f/b;

    invoke-direct {v2}, La/b/c/f/b;-><init>()V

    iput-object v2, v1, La/b/b/a/d$a;->e:La/b/c/f/b;

    .line 681
    :cond_1
    iget-object v1, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v1, v1, La/b/b/a/d$a;->d:Ljava/util/ArrayList;

    invoke-virtual {v1, p2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 682
    iget-object v1, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v1, v1, La/b/b/a/d$a;->e:La/b/c/f/b;

    invoke-virtual {v1, p2, p1}, La/b/c/f/m;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 686
    return-void
.end method


# virtual methods
.method public applyTheme(Landroid/content/res/Resources$Theme;)V
    .locals 1
    .param p1, "t"    # Landroid/content/res/Resources$Theme;

    .line 512
    iget-object v0, p0, La/b/b/a/i;->a:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 513
    invoke-static {v0, p1}, Landroid/support/v4/graphics/drawable/a;->a(Landroid/graphics/drawable/Drawable;Landroid/content/res/Resources$Theme;)V

    .line 514
    return-void

    .line 517
    :cond_0
    return-void
.end method

.method public canApplyTheme()Z
    .locals 1

    .line 522
    iget-object v0, p0, La/b/b/a/i;->a:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 523
    invoke-static {v0}, Landroid/support/v4/graphics/drawable/a;->a(Landroid/graphics/drawable/Drawable;)Z

    move-result v0

    return v0

    .line 526
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public bridge synthetic clearColorFilter()V
    .locals 0

    .line 143
    invoke-super {p0}, La/b/b/a/i;->clearColorFilter()V

    return-void
.end method

.method public draw(Landroid/graphics/Canvas;)V
    .locals 1
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .line 284
    iget-object v0, p0, La/b/b/a/i;->a:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 285
    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    .line 286
    return-void

    .line 288
    :cond_0
    iget-object v0, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v0, v0, La/b/b/a/d$a;->b:La/b/b/a/k;

    invoke-virtual {v0, p1}, La/b/b/a/k;->draw(Landroid/graphics/Canvas;)V

    .line 289
    iget-object v0, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v0, v0, La/b/b/a/d$a;->c:Landroid/animation/AnimatorSet;

    invoke-virtual {v0}, Landroid/animation/AnimatorSet;->isStarted()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 290
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->invalidateSelf()V

    .line 292
    :cond_1
    return-void
.end method

.method public getAlpha()I
    .locals 1

    .line 321
    iget-object v0, p0, La/b/b/a/i;->a:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 322
    invoke-static {v0}, Landroid/support/v4/graphics/drawable/a;->b(Landroid/graphics/drawable/Drawable;)I

    move-result v0

    return v0

    .line 324
    :cond_0
    iget-object v0, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v0, v0, La/b/b/a/d$a;->b:La/b/b/a/k;

    invoke-virtual {v0}, La/b/b/a/k;->getAlpha()I

    move-result v0

    return v0
.end method

.method public getChangingConfigurations()I
    .locals 2

    .line 276
    iget-object v0, p0, La/b/b/a/i;->a:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 277
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getChangingConfigurations()I

    move-result v0

    return v0

    .line 279
    :cond_0
    invoke-super {p0}, Landroid/graphics/drawable/Drawable;->getChangingConfigurations()I

    move-result v0

    iget-object v1, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget v1, v1, La/b/b/a/d$a;->a:I

    or-int/2addr v0, v1

    return v0
.end method

.method public bridge synthetic getColorFilter()Landroid/graphics/ColorFilter;
    .locals 1

    .line 143
    invoke-super {p0}, La/b/b/a/i;->getColorFilter()Landroid/graphics/ColorFilter;

    move-result-object v0

    return-object v0
.end method

.method public getConstantState()Landroid/graphics/drawable/Drawable$ConstantState;
    .locals 3

    .line 265
    iget-object v0, p0, La/b/b/a/i;->a:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x18

    if-lt v1, v2, :cond_0

    .line 266
    new-instance v1, La/b/b/a/d$b;

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getConstantState()Landroid/graphics/drawable/Drawable$ConstantState;

    move-result-object v0

    invoke-direct {v1, v0}, La/b/b/a/d$b;-><init>(Landroid/graphics/drawable/Drawable$ConstantState;)V

    return-object v1

    .line 271
    :cond_0
    const/4 v0, 0x0

    return-object v0
.end method

.method public bridge synthetic getCurrent()Landroid/graphics/drawable/Drawable;
    .locals 1

    .line 143
    invoke-super {p0}, La/b/b/a/i;->getCurrent()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method public getIntrinsicHeight()I
    .locals 1

    .line 410
    iget-object v0, p0, La/b/b/a/i;->a:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 411
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v0

    return v0

    .line 413
    :cond_0
    iget-object v0, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v0, v0, La/b/b/a/d$a;->b:La/b/b/a/k;

    invoke-virtual {v0}, La/b/b/a/k;->getIntrinsicHeight()I

    move-result v0

    return v0
.end method

.method public getIntrinsicWidth()I
    .locals 1

    .line 402
    iget-object v0, p0, La/b/b/a/i;->a:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 403
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v0

    return v0

    .line 405
    :cond_0
    iget-object v0, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v0, v0, La/b/b/a/d$a;->b:La/b/b/a/k;

    invoke-virtual {v0}, La/b/b/a/k;->getIntrinsicWidth()I

    move-result v0

    return v0
.end method

.method public bridge synthetic getMinimumHeight()I
    .locals 1

    .line 143
    invoke-super {p0}, La/b/b/a/i;->getMinimumHeight()I

    move-result v0

    return v0
.end method

.method public bridge synthetic getMinimumWidth()I
    .locals 1

    .line 143
    invoke-super {p0}, La/b/b/a/i;->getMinimumWidth()I

    move-result v0

    return v0
.end method

.method public getOpacity()I
    .locals 1

    .line 394
    iget-object v0, p0, La/b/b/a/i;->a:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 395
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getOpacity()I

    move-result v0

    return v0

    .line 397
    :cond_0
    iget-object v0, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v0, v0, La/b/b/a/d$a;->b:La/b/b/a/k;

    invoke-virtual {v0}, La/b/b/a/k;->getOpacity()I

    move-result v0

    return v0
.end method

.method public bridge synthetic getPadding(Landroid/graphics/Rect;)Z
    .locals 1
    .param p1, "x0"    # Landroid/graphics/Rect;

    .line 143
    invoke-super {p0, p1}, La/b/b/a/i;->getPadding(Landroid/graphics/Rect;)Z

    move-result v0

    return v0
.end method

.method public bridge synthetic getState()[I
    .locals 1

    .line 143
    invoke-super {p0}, La/b/b/a/i;->getState()[I

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getTransparentRegion()Landroid/graphics/Region;
    .locals 1

    .line 143
    invoke-super {p0}, La/b/b/a/i;->getTransparentRegion()Landroid/graphics/Region;

    move-result-object v0

    return-object v0
.end method

.method public inflate(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "res"    # Landroid/content/res/Resources;
    .param p2, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .param p3, "attrs"    # Landroid/util/AttributeSet;

    .line 507
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, p3, v0}, La/b/b/a/d;->inflate(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)V

    .line 508
    return-void
.end method

.method public inflate(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)V
    .locals 9
    .param p1, "res"    # Landroid/content/res/Resources;
    .param p2, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .param p3, "attrs"    # Landroid/util/AttributeSet;
    .param p4, "theme"    # Landroid/content/res/Resources$Theme;

    .line 436
    iget-object v0, p0, La/b/b/a/i;->a:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 437
    invoke-static {v0, p1, p2, p3, p4}, Landroid/support/v4/graphics/drawable/a;->a(Landroid/graphics/drawable/Drawable;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)V

    .line 438
    return-void

    .line 440
    :cond_0
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->getEventType()I

    move-result v0

    .line 441
    .local v0, "eventType":I
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v1

    const/4 v2, 0x1

    add-int/2addr v1, v2

    .line 444
    .local v1, "innerDepth":I
    :goto_0
    if-eq v0, v2, :cond_8

    .line 445
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v3

    if-ge v3, v1, :cond_1

    const/4 v3, 0x3

    if-eq v0, v3, :cond_8

    .line 446
    :cond_1
    const/4 v3, 0x2

    if-ne v0, v3, :cond_7

    .line 447
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v3

    .line 451
    .local v3, "tagName":Ljava/lang/String;
    const-string v4, "animated-vector"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    const/4 v5, 0x0

    if-eqz v4, :cond_4

    .line 452
    sget-object v4, La/b/b/a/a;->e:[I

    .line 453
    invoke-static {p1, p4, p3, v4}, La/b/c/a/a/i;->a(Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v4

    .line 456
    .local v4, "a":Landroid/content/res/TypedArray;
    invoke-virtual {v4, v5, v5}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v6

    .line 461
    .local v6, "drawableRes":I
    if-eqz v6, :cond_3

    .line 462
    invoke-static {p1, v6, p4}, La/b/b/a/k;->a(Landroid/content/res/Resources;ILandroid/content/res/Resources$Theme;)La/b/b/a/k;

    move-result-object v7

    .line 464
    .local v7, "vectorDrawable":La/b/b/a/k;
    invoke-virtual {v7, v5}, La/b/b/a/k;->a(Z)V

    .line 465
    iget-object v5, p0, La/b/b/a/d;->g:Landroid/graphics/drawable/Drawable$Callback;

    invoke-virtual {v7, v5}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    .line 466
    iget-object v5, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v5, v5, La/b/b/a/d$a;->b:La/b/b/a/k;

    if-eqz v5, :cond_2

    .line 467
    const/4 v8, 0x0

    invoke-virtual {v5, v8}, Landroid/graphics/drawable/Drawable;->setCallback(Landroid/graphics/drawable/Drawable$Callback;)V

    .line 469
    :cond_2
    iget-object v5, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iput-object v7, v5, La/b/b/a/d$a;->b:La/b/b/a/k;

    .line 471
    .end local v7    # "vectorDrawable":La/b/b/a/k;
    :cond_3
    invoke-virtual {v4}, Landroid/content/res/TypedArray;->recycle()V

    .end local v4    # "a":Landroid/content/res/TypedArray;
    .end local v6    # "drawableRes":I
    goto :goto_2

    .line 472
    :cond_4
    const-string v4, "target"

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_7

    .line 473
    sget-object v4, La/b/b/a/a;->f:[I

    .line 474
    invoke-virtual {p1, p3, v4}, Landroid/content/res/Resources;->obtainAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v4

    .line 476
    .restart local v4    # "a":Landroid/content/res/TypedArray;
    invoke-virtual {v4, v5}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 479
    .local v6, "target":Ljava/lang/String;
    invoke-virtual {v4, v2, v5}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v5

    .line 482
    .local v5, "id":I
    if-eqz v5, :cond_6

    .line 483
    iget-object v7, p0, La/b/b/a/d;->c:Landroid/content/Context;

    if-eqz v7, :cond_5

    .line 486
    invoke-static {v7, v5}, La/b/b/a/f;->a(Landroid/content/Context;I)Landroid/animation/Animator;

    move-result-object v7

    .line 488
    .local v7, "objectAnimator":Landroid/animation/Animator;
    invoke-direct {p0, v6, v7}, La/b/b/a/d;->a(Ljava/lang/String;Landroid/animation/Animator;)V

    .line 489
    .end local v7    # "objectAnimator":Landroid/animation/Animator;
    goto :goto_1

    .line 490
    :cond_5
    invoke-virtual {v4}, Landroid/content/res/TypedArray;->recycle()V

    .line 491
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string v7, "Context can\'t be null when inflating animators"

    invoke-direct {v2, v7}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 495
    :cond_6
    :goto_1
    invoke-virtual {v4}, Landroid/content/res/TypedArray;->recycle()V

    nop

    .line 498
    .end local v3    # "tagName":Ljava/lang/String;
    .end local v4    # "a":Landroid/content/res/TypedArray;
    .end local v5    # "id":I
    .end local v6    # "target":Ljava/lang/String;
    :cond_7
    :goto_2
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v0

    goto :goto_0

    .line 501
    :cond_8
    iget-object v2, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    invoke-virtual {v2}, La/b/b/a/d$a;->a()V

    .line 502
    return-void
.end method

.method public isAutoMirrored()Z
    .locals 1

    .line 418
    iget-object v0, p0, La/b/b/a/i;->a:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 419
    invoke-static {v0}, Landroid/support/v4/graphics/drawable/a;->e(Landroid/graphics/drawable/Drawable;)Z

    move-result v0

    return v0

    .line 421
    :cond_0
    iget-object v0, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v0, v0, La/b/b/a/d$a;->b:La/b/b/a/k;

    invoke-virtual {v0}, La/b/b/a/k;->isAutoMirrored()Z

    move-result v0

    return v0
.end method

.method public isRunning()Z
    .locals 1

    .line 690
    iget-object v0, p0, La/b/b/a/i;->a:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 692
    check-cast v0, Landroid/graphics/drawable/AnimatedVectorDrawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/AnimatedVectorDrawable;->isRunning()Z

    move-result v0

    return v0

    .line 694
    :cond_0
    iget-object v0, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v0, v0, La/b/b/a/d$a;->c:Landroid/animation/AnimatorSet;

    invoke-virtual {v0}, Landroid/animation/AnimatorSet;->isRunning()Z

    move-result v0

    return v0
.end method

.method public isStateful()Z
    .locals 1

    .line 386
    iget-object v0, p0, La/b/b/a/i;->a:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 387
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->isStateful()Z

    move-result v0

    return v0

    .line 389
    :cond_0
    iget-object v0, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v0, v0, La/b/b/a/d$a;->b:La/b/b/a/k;

    invoke-virtual {v0}, La/b/b/a/k;->isStateful()Z

    move-result v0

    return v0
.end method

.method public bridge synthetic jumpToCurrentState()V
    .locals 0

    .line 143
    invoke-super {p0}, La/b/b/a/i;->jumpToCurrentState()V

    return-void
.end method

.method public mutate()Landroid/graphics/drawable/Drawable;
    .locals 1

    .line 193
    iget-object v0, p0, La/b/b/a/i;->a:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 194
    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->mutate()Landroid/graphics/drawable/Drawable;

    .line 198
    :cond_0
    return-object p0
.end method

.method protected onBoundsChange(Landroid/graphics/Rect;)V
    .locals 1
    .param p1, "bounds"    # Landroid/graphics/Rect;

    .line 296
    iget-object v0, p0, La/b/b/a/i;->a:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 297
    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    .line 298
    return-void

    .line 300
    :cond_0
    iget-object v0, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v0, v0, La/b/b/a/d$a;->b:La/b/b/a/k;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->setBounds(Landroid/graphics/Rect;)V

    .line 301
    return-void
.end method

.method protected onLevelChange(I)Z
    .locals 1
    .param p1, "level"    # I

    .line 313
    iget-object v0, p0, La/b/b/a/i;->a:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 314
    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->setLevel(I)Z

    move-result v0

    return v0

    .line 316
    :cond_0
    iget-object v0, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v0, v0, La/b/b/a/d$a;->b:La/b/b/a/k;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->setLevel(I)Z

    move-result v0

    return v0
.end method

.method protected onStateChange([I)Z
    .locals 1
    .param p1, "state"    # [I

    .line 305
    iget-object v0, p0, La/b/b/a/i;->a:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 306
    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    move-result v0

    return v0

    .line 308
    :cond_0
    iget-object v0, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v0, v0, La/b/b/a/d$a;->b:La/b/b/a/k;

    invoke-virtual {v0, p1}, La/b/b/a/k;->setState([I)Z

    move-result v0

    return v0
.end method

.method public setAlpha(I)V
    .locals 1
    .param p1, "alpha"    # I

    .line 329
    iget-object v0, p0, La/b/b/a/i;->a:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 330
    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->setAlpha(I)V

    .line 331
    return-void

    .line 333
    :cond_0
    iget-object v0, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v0, v0, La/b/b/a/d$a;->b:La/b/b/a/k;

    invoke-virtual {v0, p1}, La/b/b/a/k;->setAlpha(I)V

    .line 334
    return-void
.end method

.method public setAutoMirrored(Z)V
    .locals 1
    .param p1, "mirrored"    # Z

    .line 426
    iget-object v0, p0, La/b/b/a/i;->a:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 427
    invoke-static {v0, p1}, Landroid/support/v4/graphics/drawable/a;->a(Landroid/graphics/drawable/Drawable;Z)V

    .line 428
    return-void

    .line 430
    :cond_0
    iget-object v0, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v0, v0, La/b/b/a/d$a;->b:La/b/b/a/k;

    invoke-virtual {v0, p1}, La/b/b/a/k;->setAutoMirrored(Z)V

    .line 431
    return-void
.end method

.method public bridge synthetic setChangingConfigurations(I)V
    .locals 0
    .param p1, "x0"    # I

    .line 143
    invoke-super {p0, p1}, La/b/b/a/i;->setChangingConfigurations(I)V

    return-void
.end method

.method public bridge synthetic setColorFilter(ILandroid/graphics/PorterDuff$Mode;)V
    .locals 0
    .param p1, "x0"    # I
    .param p2, "x1"    # Landroid/graphics/PorterDuff$Mode;

    .line 143
    invoke-super {p0, p1, p2}, La/b/b/a/i;->setColorFilter(ILandroid/graphics/PorterDuff$Mode;)V

    return-void
.end method

.method public setColorFilter(Landroid/graphics/ColorFilter;)V
    .locals 1
    .param p1, "colorFilter"    # Landroid/graphics/ColorFilter;

    .line 338
    iget-object v0, p0, La/b/b/a/i;->a:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 339
    invoke-virtual {v0, p1}, Landroid/graphics/drawable/Drawable;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 340
    return-void

    .line 342
    :cond_0
    iget-object v0, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v0, v0, La/b/b/a/d$a;->b:La/b/b/a/k;

    invoke-virtual {v0, p1}, La/b/b/a/k;->setColorFilter(Landroid/graphics/ColorFilter;)V

    .line 343
    return-void
.end method

.method public bridge synthetic setFilterBitmap(Z)V
    .locals 0
    .param p1, "x0"    # Z

    .line 143
    invoke-super {p0, p1}, La/b/b/a/i;->setFilterBitmap(Z)V

    return-void
.end method

.method public bridge synthetic setHotspot(FF)V
    .locals 0
    .param p1, "x0"    # F
    .param p2, "x1"    # F

    .line 143
    invoke-super {p0, p1, p2}, La/b/b/a/i;->setHotspot(FF)V

    return-void
.end method

.method public bridge synthetic setHotspotBounds(IIII)V
    .locals 0
    .param p1, "x0"    # I
    .param p2, "x1"    # I
    .param p3, "x2"    # I
    .param p4, "x3"    # I

    .line 143
    invoke-super {p0, p1, p2, p3, p4}, La/b/b/a/i;->setHotspotBounds(IIII)V

    return-void
.end method

.method public bridge synthetic setState([I)Z
    .locals 1
    .param p1, "x0"    # [I

    .line 143
    invoke-super {p0, p1}, La/b/b/a/i;->setState([I)Z

    move-result v0

    return v0
.end method

.method public setTint(I)V
    .locals 1
    .param p1, "tint"    # I

    .line 347
    iget-object v0, p0, La/b/b/a/i;->a:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 348
    invoke-static {v0, p1}, Landroid/support/v4/graphics/drawable/a;->b(Landroid/graphics/drawable/Drawable;I)V

    .line 349
    return-void

    .line 352
    :cond_0
    iget-object v0, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v0, v0, La/b/b/a/d$a;->b:La/b/b/a/k;

    invoke-virtual {v0, p1}, La/b/b/a/k;->setTint(I)V

    .line 353
    return-void
.end method

.method public setTintList(Landroid/content/res/ColorStateList;)V
    .locals 1
    .param p1, "tint"    # Landroid/content/res/ColorStateList;

    .line 357
    iget-object v0, p0, La/b/b/a/i;->a:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 358
    invoke-static {v0, p1}, Landroid/support/v4/graphics/drawable/a;->a(Landroid/graphics/drawable/Drawable;Landroid/content/res/ColorStateList;)V

    .line 359
    return-void

    .line 362
    :cond_0
    iget-object v0, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v0, v0, La/b/b/a/d$a;->b:La/b/b/a/k;

    invoke-virtual {v0, p1}, La/b/b/a/k;->setTintList(Landroid/content/res/ColorStateList;)V

    .line 363
    return-void
.end method

.method public setTintMode(Landroid/graphics/PorterDuff$Mode;)V
    .locals 1
    .param p1, "tintMode"    # Landroid/graphics/PorterDuff$Mode;

    .line 367
    iget-object v0, p0, La/b/b/a/i;->a:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 368
    invoke-static {v0, p1}, Landroid/support/v4/graphics/drawable/a;->a(Landroid/graphics/drawable/Drawable;Landroid/graphics/PorterDuff$Mode;)V

    .line 369
    return-void

    .line 372
    :cond_0
    iget-object v0, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v0, v0, La/b/b/a/d$a;->b:La/b/b/a/k;

    invoke-virtual {v0, p1}, La/b/b/a/k;->setTintMode(Landroid/graphics/PorterDuff$Mode;)V

    .line 373
    return-void
.end method

.method public setVisible(ZZ)Z
    .locals 1
    .param p1, "visible"    # Z
    .param p2, "restart"    # Z

    .line 377
    iget-object v0, p0, La/b/b/a/i;->a:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 378
    invoke-virtual {v0, p1, p2}, Landroid/graphics/drawable/Drawable;->setVisible(ZZ)Z

    move-result v0

    return v0

    .line 380
    :cond_0
    iget-object v0, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v0, v0, La/b/b/a/d$a;->b:La/b/b/a/k;

    invoke-virtual {v0, p1, p2}, La/b/b/a/k;->setVisible(ZZ)Z

    .line 381
    invoke-super {p0, p1, p2}, Landroid/graphics/drawable/Drawable;->setVisible(ZZ)Z

    move-result v0

    return v0
.end method

.method public start()V
    .locals 1

    .line 699
    iget-object v0, p0, La/b/b/a/i;->a:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 701
    check-cast v0, Landroid/graphics/drawable/AnimatedVectorDrawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/AnimatedVectorDrawable;->start()V

    .line 702
    return-void

    .line 705
    :cond_0
    iget-object v0, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v0, v0, La/b/b/a/d$a;->c:Landroid/animation/AnimatorSet;

    invoke-virtual {v0}, Landroid/animation/AnimatorSet;->isStarted()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 706
    return-void

    .line 709
    :cond_1
    iget-object v0, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v0, v0, La/b/b/a/d$a;->c:Landroid/animation/AnimatorSet;

    invoke-virtual {v0}, Landroid/animation/AnimatorSet;->start()V

    .line 710
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->invalidateSelf()V

    .line 711
    return-void
.end method

.method public stop()V
    .locals 1

    .line 715
    iget-object v0, p0, La/b/b/a/i;->a:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_0

    .line 717
    check-cast v0, Landroid/graphics/drawable/AnimatedVectorDrawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/AnimatedVectorDrawable;->stop()V

    .line 718
    return-void

    .line 720
    :cond_0
    iget-object v0, p0, La/b/b/a/d;->b:La/b/b/a/d$a;

    iget-object v0, v0, La/b/b/a/d$a;->c:Landroid/animation/AnimatorSet;

    invoke-virtual {v0}, Landroid/animation/AnimatorSet;->end()V

    .line 721
    return-void
.end method
