.class public La/b/d/c/a/b;
.super La/b/d/c/a/f;
.source ""


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        La/b/d/c/a/b$e;,
        La/b/d/c/a/b$b;,
        La/b/d/c/a/b$c;,
        La/b/d/c/a/b$d;,
        La/b/d/c/a/b$a;,
        La/b/d/c/a/b$f;
    }
.end annotation


# static fields
.field private static final p:Ljava/lang/String;


# instance fields
.field private q:La/b/d/c/a/b$b;

.field private r:La/b/d/c/a/b$f;

.field private s:I

.field private t:I

.field private u:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 90
    const-class v0, La/b/d/c/a/b;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, La/b/d/c/a/b;->p:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .line 109
    const/4 v0, 0x0

    invoke-direct {p0, v0, v0}, La/b/d/c/a/b;-><init>(La/b/d/c/a/b$b;Landroid/content/res/Resources;)V

    .line 110
    return-void
.end method

.method constructor <init>(La/b/d/c/a/b$b;Landroid/content/res/Resources;)V
    .locals 2
    .param p1, "state"    # La/b/d/c/a/b$b;
    .param p2, "res"    # Landroid/content/res/Resources;

    .line 114
    const/4 v0, 0x0

    invoke-direct {p0, v0}, La/b/d/c/a/f;-><init>(La/b/d/c/a/f$a;)V

    .line 103
    const/4 v0, -0x1

    iput v0, p0, La/b/d/c/a/b;->s:I

    .line 105
    iput v0, p0, La/b/d/c/a/b;->t:I

    .line 116
    new-instance v0, La/b/d/c/a/b$b;

    invoke-direct {v0, p1, p0, p2}, La/b/d/c/a/b$b;-><init>(La/b/d/c/a/b$b;La/b/d/c/a/b;Landroid/content/res/Resources;)V

    .line 117
    .local v0, "newState":La/b/d/c/a/b$b;
    invoke-virtual {p0, v0}, La/b/d/c/a/b;->a(La/b/d/c/a/d$b;)V

    .line 118
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getState()[I

    move-result-object v1

    invoke-virtual {p0, v1}, La/b/d/c/a/b;->onStateChange([I)Z

    .line 119
    invoke-virtual {p0}, La/b/d/c/a/b;->jumpToCurrentState()V

    .line 120
    return-void
.end method

.method public static a(Landroid/content/Context;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)La/b/d/c/a/b;
    .locals 8
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "resources"    # Landroid/content/res/Resources;
    .param p2, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .param p3, "attrs"    # Landroid/util/AttributeSet;
    .param p4, "theme"    # Landroid/content/res/Resources$Theme;

    .line 170
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v0

    .line 171
    .local v0, "name":Ljava/lang/String;
    const-string v1, "animated-selector"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 175
    new-instance v1, La/b/d/c/a/b;

    invoke-direct {v1}, La/b/d/c/a/b;-><init>()V

    .line 176
    .local v1, "asl":La/b/d/c/a/b;
    move-object v2, v1

    move-object v3, p0

    move-object v4, p1

    move-object v5, p2

    move-object v6, p3

    move-object v7, p4

    invoke-virtual/range {v2 .. v7}, La/b/d/c/a/b;->b(Landroid/content/Context;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)V

    .line 177
    return-object v1

    .line 172
    .end local v1    # "asl":La/b/d/c/a/b;
    :cond_0
    new-instance v1, Lorg/xmlpull/v1/XmlPullParserException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 173
    invoke-interface {p2}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v3, ": invalid animated-selector tag "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method private a(Landroid/content/res/TypedArray;)V
    .locals 3
    .param p1, "a"    # Landroid/content/res/TypedArray;

    .line 448
    iget-object v0, p0, La/b/d/c/a/b;->q:La/b/d/c/a/b$b;

    .line 450
    .local v0, "state":La/b/d/c/a/b$b;
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x15

    if-lt v1, v2, :cond_0

    .line 451
    iget v1, v0, La/b/d/c/a/d$b;->d:I

    invoke-virtual {p1}, Landroid/content/res/TypedArray;->getChangingConfigurations()I

    move-result v2

    or-int/2addr v1, v2

    iput v1, v0, La/b/d/c/a/d$b;->d:I

    .line 454
    :cond_0
    sget v1, La/b/d/a/j;->AnimatedStateListDrawableCompat_android_variablePadding:I

    iget-boolean v2, v0, La/b/d/c/a/d$b;->i:Z

    .line 455
    invoke-virtual {p1, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    .line 454
    invoke-virtual {v0, v1}, La/b/d/c/a/d$b;->b(Z)V

    .line 457
    sget v1, La/b/d/a/j;->AnimatedStateListDrawableCompat_android_constantSize:I

    iget-boolean v2, v0, La/b/d/c/a/d$b;->l:Z

    .line 458
    invoke-virtual {p1, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    .line 457
    invoke-virtual {v0, v1}, La/b/d/c/a/d$b;->a(Z)V

    .line 460
    sget v1, La/b/d/a/j;->AnimatedStateListDrawableCompat_android_enterFadeDuration:I

    iget v2, v0, La/b/d/c/a/d$b;->A:I

    .line 461
    invoke-virtual {p1, v1, v2}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v1

    .line 460
    invoke-virtual {v0, v1}, La/b/d/c/a/d$b;->b(I)V

    .line 463
    sget v1, La/b/d/a/j;->AnimatedStateListDrawableCompat_android_exitFadeDuration:I

    iget v2, v0, La/b/d/c/a/d$b;->B:I

    .line 464
    invoke-virtual {p1, v1, v2}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v1

    .line 463
    invoke-virtual {v0, v1}, La/b/d/c/a/d$b;->c(I)V

    .line 466
    sget v1, La/b/d/a/j;->AnimatedStateListDrawableCompat_android_dither:I

    iget-boolean v2, v0, La/b/d/c/a/d$b;->x:Z

    invoke-virtual {p1, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    invoke-virtual {p0, v1}, La/b/d/c/a/b;->setDither(Z)V

    .line 468
    return-void
.end method

.method private b(I)Z
    .locals 12
    .param p1, "toIndex"    # I

    .line 292
    iget-object v0, p0, La/b/d/c/a/b;->r:La/b/d/c/a/b$f;

    .line 293
    .local v0, "currentTransition":La/b/d/c/a/b$f;
    const/4 v1, 0x1

    if-eqz v0, :cond_2

    .line 294
    iget v2, p0, La/b/d/c/a/b;->s:I

    if-ne p1, v2, :cond_0

    .line 296
    return v1

    .line 297
    :cond_0
    iget v2, p0, La/b/d/c/a/b;->t:I

    if-ne p1, v2, :cond_1

    invoke-virtual {v0}, La/b/d/c/a/b$f;->a()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 299
    invoke-virtual {v0}, La/b/d/c/a/b$f;->b()V

    .line 300
    iget v2, p0, La/b/d/c/a/b;->t:I

    iput v2, p0, La/b/d/c/a/b;->s:I

    .line 301
    iput p1, p0, La/b/d/c/a/b;->t:I

    .line 302
    return v1

    .line 305
    :cond_1
    iget v2, p0, La/b/d/c/a/b;->s:I

    .line 307
    .local v2, "fromIndex":I
    invoke-virtual {v0}, La/b/d/c/a/b$f;->d()V

    goto :goto_0

    .line 309
    .end local v2    # "fromIndex":I
    :cond_2
    invoke-virtual {p0}, La/b/d/c/a/d;->b()I

    move-result v2

    .line 312
    .restart local v2    # "fromIndex":I
    :goto_0
    const/4 v3, 0x0

    iput-object v3, p0, La/b/d/c/a/b;->r:La/b/d/c/a/b$f;

    .line 313
    const/4 v3, -0x1

    iput v3, p0, La/b/d/c/a/b;->t:I

    .line 314
    iput v3, p0, La/b/d/c/a/b;->s:I

    .line 315
    iget-object v3, p0, La/b/d/c/a/b;->q:La/b/d/c/a/b$b;

    .line 316
    .local v3, "state":La/b/d/c/a/b$b;
    invoke-virtual {v3, v2}, La/b/d/c/a/b$b;->d(I)I

    move-result v4

    .line 317
    .local v4, "fromId":I
    invoke-virtual {v3, p1}, La/b/d/c/a/b$b;->d(I)I

    move-result v5

    .line 318
    .local v5, "toId":I
    const/4 v6, 0x0

    if-eqz v5, :cond_8

    if-nez v4, :cond_3

    goto :goto_2

    .line 322
    :cond_3
    invoke-virtual {v3, v4, v5}, La/b/d/c/a/b$b;->c(II)I

    move-result v7

    .line 323
    .local v7, "transitionIndex":I
    if-gez v7, :cond_4

    .line 325
    return v6

    .line 327
    :cond_4
    invoke-virtual {v3, v4, v5}, La/b/d/c/a/b$b;->e(II)Z

    move-result v8

    .line 329
    .local v8, "hasReversibleFlag":Z
    invoke-virtual {p0, v7}, La/b/d/c/a/d;->a(I)Z

    .line 331
    invoke-virtual {p0}, La/b/d/c/a/b;->getCurrent()Landroid/graphics/drawable/Drawable;

    move-result-object v9

    .line 332
    .local v9, "d":Landroid/graphics/drawable/Drawable;
    instance-of v10, v9, Landroid/graphics/drawable/AnimationDrawable;

    if-eqz v10, :cond_5

    .line 333
    invoke-virtual {v3, v4, v5}, La/b/d/c/a/b$b;->d(II)Z

    move-result v6

    .line 334
    .local v6, "reversed":Z
    new-instance v10, La/b/d/c/a/b$d;

    move-object v11, v9

    check-cast v11, Landroid/graphics/drawable/AnimationDrawable;

    invoke-direct {v10, v11, v6, v8}, La/b/d/c/a/b$d;-><init>(Landroid/graphics/drawable/AnimationDrawable;ZZ)V

    move-object v6, v10

    .line 336
    .local v6, "transition":La/b/d/c/a/b$f;
    goto :goto_1

    .end local v6    # "transition":La/b/d/c/a/b$f;
    :cond_5
    instance-of v10, v9, La/b/b/a/d;

    if-eqz v10, :cond_6

    .line 338
    new-instance v6, La/b/d/c/a/b$c;

    move-object v10, v9

    check-cast v10, La/b/b/a/d;

    invoke-direct {v6, v10}, La/b/d/c/a/b$c;-><init>(La/b/b/a/d;)V

    .restart local v6    # "transition":La/b/d/c/a/b$f;
    goto :goto_1

    .line 339
    .end local v6    # "transition":La/b/d/c/a/b$f;
    :cond_6
    instance-of v10, v9, Landroid/graphics/drawable/Animatable;

    if-eqz v10, :cond_7

    .line 340
    new-instance v6, La/b/d/c/a/b$a;

    move-object v10, v9

    check-cast v10, Landroid/graphics/drawable/Animatable;

    invoke-direct {v6, v10}, La/b/d/c/a/b$a;-><init>(Landroid/graphics/drawable/Animatable;)V

    .line 345
    .restart local v6    # "transition":La/b/d/c/a/b$f;
    :goto_1
    invoke-virtual {v6}, La/b/d/c/a/b$f;->c()V

    .line 346
    iput-object v6, p0, La/b/d/c/a/b;->r:La/b/d/c/a/b$f;

    .line 347
    iput v2, p0, La/b/d/c/a/b;->t:I

    .line 348
    iput p1, p0, La/b/d/c/a/b;->s:I

    .line 349
    return v1

    .line 343
    .end local v6    # "transition":La/b/d/c/a/b$f;
    :cond_7
    return v6

    .line 320
    .end local v7    # "transitionIndex":I
    .end local v8    # "hasReversibleFlag":Z
    .end local v9    # "d":Landroid/graphics/drawable/Drawable;
    :cond_8
    :goto_2
    return v6
.end method

.method private c(Landroid/content/Context;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "resources"    # Landroid/content/res/Resources;
    .param p3, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .param p4, "attrs"    # Landroid/util/AttributeSet;
    .param p5, "theme"    # Landroid/content/res/Resources$Theme;

    .line 482
    invoke-interface {p3}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v0

    const/4 v1, 0x1

    add-int/2addr v0, v1

    .line 484
    .local v0, "innerDepth":I
    :cond_0
    :goto_0
    invoke-interface {p3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v2

    move v3, v2

    .local v3, "type":I
    if-eq v2, v1, :cond_5

    .line 485
    invoke-interface {p3}, Lorg/xmlpull/v1/XmlPullParser;->getDepth()I

    move-result v2

    move v4, v2

    .local v4, "depth":I
    if-ge v2, v0, :cond_1

    const/4 v2, 0x3

    if-eq v3, v2, :cond_5

    .line 487
    :cond_1
    const/4 v2, 0x2

    if-eq v3, v2, :cond_2

    .line 488
    goto :goto_0

    .line 490
    :cond_2
    if-le v4, v0, :cond_3

    .line 491
    goto :goto_0

    .line 493
    :cond_3
    invoke-interface {p3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v5, "item"

    invoke-virtual {v2, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 494
    invoke-direct/range {p0 .. p5}, La/b/d/c/a/b;->d(Landroid/content/Context;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)I

    goto :goto_0

    .line 495
    :cond_4
    invoke-interface {p3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v2

    const-string v5, "transition"

    invoke-virtual {v2, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 496
    invoke-direct/range {p0 .. p5}, La/b/d/c/a/b;->e(Landroid/content/Context;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)I

    goto :goto_0

    .line 499
    .end local v4    # "depth":I
    :cond_5
    return-void
.end method

.method private d(Landroid/content/Context;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)I
    .locals 10
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "resources"    # Landroid/content/res/Resources;
    .param p3, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .param p4, "attrs"    # Landroid/util/AttributeSet;
    .param p5, "theme"    # Landroid/content/res/Resources$Theme;

    .line 563
    sget-object v0, La/b/d/a/j;->AnimatedStateListDrawableItem:[I

    invoke-static {p2, p5, p4, v0}, La/b/c/a/a/i;->a(Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 565
    .local v0, "a":Landroid/content/res/TypedArray;
    sget v1, La/b/d/a/j;->AnimatedStateListDrawableItem_android_id:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v1

    .line 567
    .local v1, "keyframeId":I
    const/4 v2, 0x0

    .line 568
    .local v2, "dr":Landroid/graphics/drawable/Drawable;
    sget v3, La/b/d/a/j;->AnimatedStateListDrawableItem_android_drawable:I

    .line 569
    const/4 v4, -0x1

    invoke-virtual {v0, v3, v4}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v3

    .line 570
    .local v3, "drawableId":I
    if-lez v3, :cond_0

    .line 571
    invoke-static {p1, v3}, La/b/d/b/a/a;->b(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 573
    :cond_0
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 574
    invoke-virtual {p0, p4}, La/b/d/c/a/f;->a(Landroid/util/AttributeSet;)[I

    move-result-object v4

    .line 577
    .local v4, "states":[I
    const-string v5, ": <item> tag requires a \'drawable\' attribute or child tag defining a drawable"

    if-nez v2, :cond_5

    .line 579
    :goto_0
    invoke-interface {p3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v6

    move v7, v6

    .local v7, "type":I
    const/4 v8, 0x4

    if-ne v6, v8, :cond_1

    goto :goto_0

    .line 582
    :cond_1
    const/4 v6, 0x2

    if-ne v7, v6, :cond_4

    .line 587
    invoke-interface {p3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v6

    const-string v8, "vector"

    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 588
    invoke-static {p2, p3, p4, p5}, La/b/b/a/k;->createFromXmlInner(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)La/b/b/a/k;

    move-result-object v2

    goto :goto_1

    .line 589
    :cond_2
    sget v6, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v8, 0x15

    if-lt v6, v8, :cond_3

    .line 590
    invoke-static {p2, p3, p4, p5}, Landroid/graphics/drawable/Drawable;->createFromXmlInner(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    goto :goto_1

    .line 592
    :cond_3
    invoke-static {p2, p3, p4}, Landroid/graphics/drawable/Drawable;->createFromXmlInner(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    goto :goto_1

    .line 583
    :cond_4
    new-instance v6, Lorg/xmlpull/v1/XmlPullParserException;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    .line 584
    invoke-interface {p3}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v8, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v6, v5}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 595
    .end local v7    # "type":I
    :cond_5
    :goto_1
    if-eqz v2, :cond_6

    .line 599
    iget-object v5, p0, La/b/d/c/a/b;->q:La/b/d/c/a/b$b;

    invoke-virtual {v5, v4, v2, v1}, La/b/d/c/a/b$b;->a([ILandroid/graphics/drawable/Drawable;I)I

    move-result v5

    return v5

    .line 596
    :cond_6
    new-instance v6, Lorg/xmlpull/v1/XmlPullParserException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    .line 597
    invoke-interface {p3}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v6, v5}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    goto :goto_3

    :goto_2
    throw v6

    :goto_3
    goto :goto_2
.end method

.method private d()V
    .locals 1

    .line 471
    invoke-virtual {p0}, Landroid/graphics/drawable/Drawable;->getState()[I

    move-result-object v0

    invoke-virtual {p0, v0}, La/b/d/c/a/b;->onStateChange([I)Z

    .line 472
    return-void
.end method

.method private e(Landroid/content/Context;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)I
    .locals 15
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "resources"    # Landroid/content/res/Resources;
    .param p3, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .param p4, "attrs"    # Landroid/util/AttributeSet;
    .param p5, "theme"    # Landroid/content/res/Resources$Theme;

    .line 509
    sget-object v0, La/b/d/a/j;->AnimatedStateListDrawableTransition:[I

    move-object/from16 v1, p2

    move-object/from16 v2, p4

    move-object/from16 v3, p5

    invoke-static {v1, v3, v2, v0}, La/b/c/a/a/i;->a(Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 511
    .local v0, "a":Landroid/content/res/TypedArray;
    sget v4, La/b/d/a/j;->AnimatedStateListDrawableTransition_android_fromId:I

    const/4 v5, -0x1

    invoke-virtual {v0, v4, v5}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v4

    .line 513
    .local v4, "fromId":I
    sget v6, La/b/d/a/j;->AnimatedStateListDrawableTransition_android_toId:I

    invoke-virtual {v0, v6, v5}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v6

    .line 515
    .local v6, "toId":I
    const/4 v7, 0x0

    .line 516
    .local v7, "dr":Landroid/graphics/drawable/Drawable;
    sget v8, La/b/d/a/j;->AnimatedStateListDrawableTransition_android_drawable:I

    invoke-virtual {v0, v8, v5}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v8

    .line 518
    .local v8, "drawableId":I
    if-lez v8, :cond_0

    .line 519
    move-object/from16 v9, p1

    invoke-static {v9, v8}, La/b/d/b/a/a;->b(Landroid/content/Context;I)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    goto :goto_0

    .line 518
    :cond_0
    move-object/from16 v9, p1

    .line 521
    :goto_0
    sget v10, La/b/d/a/j;->AnimatedStateListDrawableTransition_android_reversible:I

    const/4 v11, 0x0

    invoke-virtual {v0, v10, v11}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v10

    .line 523
    .local v10, "reversible":Z
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 526
    const-string v11, ": <transition> tag requires a \'drawable\' attribute or child tag defining a drawable"

    if-nez v7, :cond_5

    .line 528
    :goto_1
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->next()I

    move-result v12

    move v13, v12

    .local v13, "type":I
    const/4 v14, 0x4

    if-ne v12, v14, :cond_1

    goto :goto_1

    .line 531
    :cond_1
    const/4 v12, 0x2

    if-ne v13, v12, :cond_4

    .line 536
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getName()Ljava/lang/String;

    move-result-object v12

    const-string v14, "animated-vector"

    invoke-virtual {v12, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_2

    .line 537
    invoke-static/range {p1 .. p5}, La/b/b/a/d;->a(Landroid/content/Context;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)La/b/b/a/d;

    move-result-object v7

    goto :goto_2

    .line 539
    :cond_2
    sget v12, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v14, 0x15

    if-lt v12, v14, :cond_3

    .line 540
    invoke-static/range {p2 .. p5}, Landroid/graphics/drawable/Drawable;->createFromXmlInner(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    goto :goto_2

    .line 542
    :cond_3
    invoke-static/range {p2 .. p4}, Landroid/graphics/drawable/Drawable;->createFromXmlInner(Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    goto :goto_2

    .line 532
    :cond_4
    new-instance v5, Lorg/xmlpull/v1/XmlPullParserException;

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    .line 533
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v12, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v12, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v5, v11}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 545
    .end local v13    # "type":I
    :cond_5
    :goto_2
    if-eqz v7, :cond_7

    .line 549
    if-eq v4, v5, :cond_6

    if-eq v6, v5, :cond_6

    .line 553
    move-object v5, p0

    iget-object v11, v5, La/b/d/c/a/b;->q:La/b/d/c/a/b$b;

    invoke-virtual {v11, v4, v6, v7, v10}, La/b/d/c/a/b$b;->a(IILandroid/graphics/drawable/Drawable;Z)I

    move-result v11

    return v11

    .line 549
    :cond_6
    move-object v5, p0

    .line 550
    new-instance v11, Lorg/xmlpull/v1/XmlPullParserException;

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    .line 551
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v13, ": <transition> tag requires \'fromId\' & \'toId\' attributes"

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-direct {v11, v12}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    throw v11

    .line 546
    :cond_7
    move-object v5, p0

    new-instance v12, Lorg/xmlpull/v1/XmlPullParserException;

    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    .line 547
    invoke-interface/range {p3 .. p3}, Lorg/xmlpull/v1/XmlPullParser;->getPositionDescription()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v13, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-direct {v12, v11}, Lorg/xmlpull/v1/XmlPullParserException;-><init>(Ljava/lang/String;)V

    goto :goto_4

    :goto_3
    throw v12

    :goto_4
    goto :goto_3
.end method


# virtual methods
.method a()La/b/d/c/a/b$b;
    .locals 3

    .line 613
    new-instance v0, La/b/d/c/a/b$b;

    iget-object v1, p0, La/b/d/c/a/b;->q:La/b/d/c/a/b$b;

    const/4 v2, 0x0

    invoke-direct {v0, v1, p0, v2}, La/b/d/c/a/b$b;-><init>(La/b/d/c/a/b$b;La/b/d/c/a/b;Landroid/content/res/Resources;)V

    return-object v0
.end method

.method bridge synthetic a()La/b/d/c/a/d$b;
    .locals 1

    .line 89
    invoke-virtual {p0}, La/b/d/c/a/b;->a()La/b/d/c/a/b$b;

    move-result-object v0

    return-object v0
.end method

.method bridge synthetic a()La/b/d/c/a/f$a;
    .locals 1

    .line 89
    invoke-virtual {p0}, La/b/d/c/a/b;->a()La/b/d/c/a/b$b;

    move-result-object v0

    return-object v0
.end method

.method protected a(La/b/d/c/a/d$b;)V
    .locals 1
    .param p1, "state"    # La/b/d/c/a/d$b;

    .line 717
    invoke-super {p0, p1}, La/b/d/c/a/f;->a(La/b/d/c/a/d$b;)V

    .line 718
    instance-of v0, p1, La/b/d/c/a/b$b;

    if-eqz v0, :cond_0

    .line 719
    move-object v0, p1

    check-cast v0, La/b/d/c/a/b$b;

    iput-object v0, p0, La/b/d/c/a/b;->q:La/b/d/c/a/b$b;

    .line 721
    :cond_0
    return-void
.end method

.method public bridge synthetic applyTheme(Landroid/content/res/Resources$Theme;)V
    .locals 0

    .line 89
    invoke-super {p0, p1}, La/b/d/c/a/f;->applyTheme(Landroid/content/res/Resources$Theme;)V

    return-void
.end method

.method public b(Landroid/content/Context;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "resources"    # Landroid/content/res/Resources;
    .param p3, "parser"    # Lorg/xmlpull/v1/XmlPullParser;
    .param p4, "attrs"    # Landroid/util/AttributeSet;
    .param p5, "theme"    # Landroid/content/res/Resources$Theme;

    .line 200
    sget-object v0, La/b/d/a/j;->AnimatedStateListDrawableCompat:[I

    invoke-static {p2, p5, p4, v0}, La/b/c/a/a/i;->a(Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 202
    .local v0, "a":Landroid/content/res/TypedArray;
    sget v1, La/b/d/a/j;->AnimatedStateListDrawableCompat_android_visible:I

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    invoke-virtual {p0, v1, v2}, La/b/d/c/a/b;->setVisible(ZZ)Z

    .line 204
    invoke-direct {p0, v0}, La/b/d/c/a/b;->a(Landroid/content/res/TypedArray;)V

    .line 205
    invoke-virtual {p0, p2}, La/b/d/c/a/d;->a(Landroid/content/res/Resources;)V

    .line 206
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 207
    invoke-direct/range {p0 .. p5}, La/b/d/c/a/b;->c(Landroid/content/Context;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;)V

    .line 208
    invoke-direct {p0}, La/b/d/c/a/b;->d()V

    .line 209
    return-void
.end method

.method public bridge synthetic canApplyTheme()Z
    .locals 1

    .line 89
    invoke-super {p0}, La/b/d/c/a/d;->canApplyTheme()Z

    move-result v0

    return v0
.end method

.method public bridge synthetic draw(Landroid/graphics/Canvas;)V
    .locals 0

    .line 89
    invoke-super {p0, p1}, La/b/d/c/a/d;->draw(Landroid/graphics/Canvas;)V

    return-void
.end method

.method public bridge synthetic getAlpha()I
    .locals 1

    .line 89
    invoke-super {p0}, La/b/d/c/a/d;->getAlpha()I

    move-result v0

    return v0
.end method

.method public bridge synthetic getChangingConfigurations()I
    .locals 1

    .line 89
    invoke-super {p0}, La/b/d/c/a/d;->getChangingConfigurations()I

    move-result v0

    return v0
.end method

.method public bridge synthetic getCurrent()Landroid/graphics/drawable/Drawable;
    .locals 1

    .line 89
    invoke-super {p0}, La/b/d/c/a/d;->getCurrent()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getHotspotBounds(Landroid/graphics/Rect;)V
    .locals 0

    .line 89
    invoke-super {p0, p1}, La/b/d/c/a/d;->getHotspotBounds(Landroid/graphics/Rect;)V

    return-void
.end method

.method public bridge synthetic getIntrinsicHeight()I
    .locals 1

    .line 89
    invoke-super {p0}, La/b/d/c/a/d;->getIntrinsicHeight()I

    move-result v0

    return v0
.end method

.method public bridge synthetic getIntrinsicWidth()I
    .locals 1

    .line 89
    invoke-super {p0}, La/b/d/c/a/d;->getIntrinsicWidth()I

    move-result v0

    return v0
.end method

.method public bridge synthetic getMinimumHeight()I
    .locals 1

    .line 89
    invoke-super {p0}, La/b/d/c/a/d;->getMinimumHeight()I

    move-result v0

    return v0
.end method

.method public bridge synthetic getMinimumWidth()I
    .locals 1

    .line 89
    invoke-super {p0}, La/b/d/c/a/d;->getMinimumWidth()I

    move-result v0

    return v0
.end method

.method public bridge synthetic getOpacity()I
    .locals 1

    .line 89
    invoke-super {p0}, La/b/d/c/a/d;->getOpacity()I

    move-result v0

    return v0
.end method

.method public bridge synthetic getOutline(Landroid/graphics/Outline;)V
    .locals 0

    .line 89
    invoke-super {p0, p1}, La/b/d/c/a/d;->getOutline(Landroid/graphics/Outline;)V

    return-void
.end method

.method public bridge synthetic getPadding(Landroid/graphics/Rect;)Z
    .locals 0

    .line 89
    invoke-super {p0, p1}, La/b/d/c/a/d;->getPadding(Landroid/graphics/Rect;)Z

    move-result p1

    return p1
.end method

.method public bridge synthetic invalidateDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 0

    .line 89
    invoke-super {p0, p1}, La/b/d/c/a/d;->invalidateDrawable(Landroid/graphics/drawable/Drawable;)V

    return-void
.end method

.method public bridge synthetic isAutoMirrored()Z
    .locals 1

    .line 89
    invoke-super {p0}, La/b/d/c/a/d;->isAutoMirrored()Z

    move-result v0

    return v0
.end method

.method public isStateful()Z
    .locals 1

    .line 258
    const/4 v0, 0x1

    return v0
.end method

.method public jumpToCurrentState()V
    .locals 1

    .line 263
    invoke-super {p0}, La/b/d/c/a/d;->jumpToCurrentState()V

    .line 264
    iget-object v0, p0, La/b/d/c/a/b;->r:La/b/d/c/a/b$f;

    if-eqz v0, :cond_0

    .line 265
    invoke-virtual {v0}, La/b/d/c/a/b$f;->d()V

    .line 266
    const/4 v0, 0x0

    iput-object v0, p0, La/b/d/c/a/b;->r:La/b/d/c/a/b$f;

    .line 267
    iget v0, p0, La/b/d/c/a/b;->s:I

    invoke-virtual {p0, v0}, La/b/d/c/a/d;->a(I)Z

    .line 268
    const/4 v0, -0x1

    iput v0, p0, La/b/d/c/a/b;->s:I

    .line 269
    iput v0, p0, La/b/d/c/a/b;->t:I

    .line 271
    :cond_0
    return-void
.end method

.method public mutate()Landroid/graphics/drawable/Drawable;
    .locals 1

    .line 604
    iget-boolean v0, p0, La/b/d/c/a/b;->u:Z

    if-nez v0, :cond_0

    invoke-super {p0}, La/b/d/c/a/f;->mutate()Landroid/graphics/drawable/Drawable;

    if-ne p0, p0, :cond_0

    .line 605
    iget-object v0, p0, La/b/d/c/a/b;->q:La/b/d/c/a/b$b;

    invoke-virtual {v0}, La/b/d/c/a/b$b;->m()V

    .line 606
    const/4 v0, 0x1

    iput-boolean v0, p0, La/b/d/c/a/b;->u:Z

    .line 608
    :cond_0
    return-object p0
.end method

.method public bridge synthetic onLayoutDirectionChanged(I)Z
    .locals 0

    .line 89
    invoke-super {p0, p1}, La/b/d/c/a/d;->onLayoutDirectionChanged(I)Z

    move-result p1

    return p1
.end method

.method protected onStateChange([I)Z
    .locals 4
    .param p1, "stateSet"    # [I

    .line 277
    iget-object v0, p0, La/b/d/c/a/b;->q:La/b/d/c/a/b$b;

    invoke-virtual {v0, p1}, La/b/d/c/a/b$b;->b([I)I

    move-result v0

    .line 278
    .local v0, "targetIndex":I
    invoke-virtual {p0}, La/b/d/c/a/d;->b()I

    move-result v1

    if-eq v0, v1, :cond_1

    .line 279
    invoke-direct {p0, v0}, La/b/d/c/a/b;->b(I)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {p0, v0}, La/b/d/c/a/d;->a(I)Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    const/4 v1, 0x1

    goto :goto_0

    :cond_1
    const/4 v1, 0x0

    .line 283
    .local v1, "changed":Z
    :goto_0
    invoke-virtual {p0}, La/b/d/c/a/b;->getCurrent()Landroid/graphics/drawable/Drawable;

    move-result-object v2

    .line 284
    .local v2, "current":Landroid/graphics/drawable/Drawable;
    if-eqz v2, :cond_2

    .line 285
    invoke-virtual {v2, p1}, Landroid/graphics/drawable/Drawable;->setState([I)Z

    move-result v3

    or-int/2addr v1, v3

    .line 287
    :cond_2
    return v1
.end method

.method public bridge synthetic scheduleDrawable(Landroid/graphics/drawable/Drawable;Ljava/lang/Runnable;J)V
    .locals 0

    .line 89
    invoke-super {p0, p1, p2, p3, p4}, La/b/d/c/a/d;->scheduleDrawable(Landroid/graphics/drawable/Drawable;Ljava/lang/Runnable;J)V

    return-void
.end method

.method public bridge synthetic setAlpha(I)V
    .locals 0

    .line 89
    invoke-super {p0, p1}, La/b/d/c/a/d;->setAlpha(I)V

    return-void
.end method

.method public bridge synthetic setAutoMirrored(Z)V
    .locals 0

    .line 89
    invoke-super {p0, p1}, La/b/d/c/a/d;->setAutoMirrored(Z)V

    return-void
.end method

.method public bridge synthetic setColorFilter(Landroid/graphics/ColorFilter;)V
    .locals 0

    .line 89
    invoke-super {p0, p1}, La/b/d/c/a/d;->setColorFilter(Landroid/graphics/ColorFilter;)V

    return-void
.end method

.method public bridge synthetic setDither(Z)V
    .locals 0

    .line 89
    invoke-super {p0, p1}, La/b/d/c/a/d;->setDither(Z)V

    return-void
.end method

.method public bridge synthetic setHotspot(FF)V
    .locals 0

    .line 89
    invoke-super {p0, p1, p2}, La/b/d/c/a/d;->setHotspot(FF)V

    return-void
.end method

.method public bridge synthetic setHotspotBounds(IIII)V
    .locals 0

    .line 89
    invoke-super {p0, p1, p2, p3, p4}, La/b/d/c/a/d;->setHotspotBounds(IIII)V

    return-void
.end method

.method public bridge synthetic setTintList(Landroid/content/res/ColorStateList;)V
    .locals 0

    .line 89
    invoke-super {p0, p1}, La/b/d/c/a/d;->setTintList(Landroid/content/res/ColorStateList;)V

    return-void
.end method

.method public bridge synthetic setTintMode(Landroid/graphics/PorterDuff$Mode;)V
    .locals 0

    .line 89
    invoke-super {p0, p1}, La/b/d/c/a/d;->setTintMode(Landroid/graphics/PorterDuff$Mode;)V

    return-void
.end method

.method public setVisible(ZZ)Z
    .locals 2
    .param p1, "visible"    # Z
    .param p2, "restart"    # Z

    .line 213
    invoke-super {p0, p1, p2}, La/b/d/c/a/d;->setVisible(ZZ)Z

    move-result v0

    .line 214
    .local v0, "changed":Z
    iget-object v1, p0, La/b/d/c/a/b;->r:La/b/d/c/a/b$f;

    if-eqz v1, :cond_2

    if-nez v0, :cond_0

    if-eqz p2, :cond_2

    .line 215
    :cond_0
    if-eqz p1, :cond_1

    .line 216
    iget-object v1, p0, La/b/d/c/a/b;->r:La/b/d/c/a/b$f;

    invoke-virtual {v1}, La/b/d/c/a/b$f;->c()V

    goto :goto_0

    .line 219
    :cond_1
    invoke-virtual {p0}, La/b/d/c/a/b;->jumpToCurrentState()V

    .line 222
    :cond_2
    :goto_0
    return v0
.end method

.method public bridge synthetic unscheduleDrawable(Landroid/graphics/drawable/Drawable;Ljava/lang/Runnable;)V
    .locals 0

    .line 89
    invoke-super {p0, p1, p2}, La/b/d/c/a/d;->unscheduleDrawable(Landroid/graphics/drawable/Drawable;Ljava/lang/Runnable;)V

    return-void
.end method
