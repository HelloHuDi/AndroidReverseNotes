.class La/b/b/a/k$c;
.super La/b/b/a/k$d;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La/b/b/a/k;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "c"
.end annotation


# instance fields
.field final a:Landroid/graphics/Matrix;

.field final b:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList<",
            "La/b/b/a/k$d;",
            ">;"
        }
    .end annotation
.end field

.field c:F

.field private d:F

.field private e:F

.field private f:F

.field private g:F

.field private h:F

.field private i:F

.field final j:Landroid/graphics/Matrix;

.field k:I

.field private l:[I

.field private m:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 3

    .line 1491
    const/4 v0, 0x0

    invoke-direct {p0, v0}, La/b/b/a/k$d;-><init>(La/b/b/a/j;)V

    .line 1430
    new-instance v1, Landroid/graphics/Matrix;

    invoke-direct {v1}, Landroid/graphics/Matrix;-><init>()V

    iput-object v1, p0, La/b/b/a/k$c;->a:Landroid/graphics/Matrix;

    .line 1434
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, La/b/b/a/k$c;->b:Ljava/util/ArrayList;

    .line 1436
    const/4 v1, 0x0

    iput v1, p0, La/b/b/a/k$c;->c:F

    .line 1437
    iput v1, p0, La/b/b/a/k$c;->d:F

    .line 1438
    iput v1, p0, La/b/b/a/k$c;->e:F

    .line 1439
    const/high16 v2, 0x3f800000    # 1.0f

    iput v2, p0, La/b/b/a/k$c;->f:F

    .line 1440
    iput v2, p0, La/b/b/a/k$c;->g:F

    .line 1441
    iput v1, p0, La/b/b/a/k$c;->h:F

    .line 1442
    iput v1, p0, La/b/b/a/k$c;->i:F

    .line 1446
    new-instance v1, Landroid/graphics/Matrix;

    invoke-direct {v1}, Landroid/graphics/Matrix;-><init>()V

    iput-object v1, p0, La/b/b/a/k$c;->j:Landroid/graphics/Matrix;

    .line 1449
    iput-object v0, p0, La/b/b/a/k$c;->m:Ljava/lang/String;

    .line 1492
    return-void
.end method

.method public constructor <init>(La/b/b/a/k$c;La/b/c/f/b;)V
    .locals 6
    .param p1, "copy"    # La/b/b/a/k$c;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "La/b/b/a/k$c;",
            "La/b/c/f/b<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .line 1451
    .local p2, "targetsMap":La/b/c/f/b;, "Landroid/support/v4/util/ArrayMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const/4 v0, 0x0

    invoke-direct {p0, v0}, La/b/b/a/k$d;-><init>(La/b/b/a/j;)V

    .line 1430
    new-instance v1, Landroid/graphics/Matrix;

    invoke-direct {v1}, Landroid/graphics/Matrix;-><init>()V

    iput-object v1, p0, La/b/b/a/k$c;->a:Landroid/graphics/Matrix;

    .line 1434
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, La/b/b/a/k$c;->b:Ljava/util/ArrayList;

    .line 1436
    const/4 v1, 0x0

    iput v1, p0, La/b/b/a/k$c;->c:F

    .line 1437
    iput v1, p0, La/b/b/a/k$c;->d:F

    .line 1438
    iput v1, p0, La/b/b/a/k$c;->e:F

    .line 1439
    const/high16 v2, 0x3f800000    # 1.0f

    iput v2, p0, La/b/b/a/k$c;->f:F

    .line 1440
    iput v2, p0, La/b/b/a/k$c;->g:F

    .line 1441
    iput v1, p0, La/b/b/a/k$c;->h:F

    .line 1442
    iput v1, p0, La/b/b/a/k$c;->i:F

    .line 1446
    new-instance v1, Landroid/graphics/Matrix;

    invoke-direct {v1}, Landroid/graphics/Matrix;-><init>()V

    iput-object v1, p0, La/b/b/a/k$c;->j:Landroid/graphics/Matrix;

    .line 1449
    iput-object v0, p0, La/b/b/a/k$c;->m:Ljava/lang/String;

    .line 1452
    iget v0, p1, La/b/b/a/k$c;->c:F

    iput v0, p0, La/b/b/a/k$c;->c:F

    .line 1453
    iget v0, p1, La/b/b/a/k$c;->d:F

    iput v0, p0, La/b/b/a/k$c;->d:F

    .line 1454
    iget v0, p1, La/b/b/a/k$c;->e:F

    iput v0, p0, La/b/b/a/k$c;->e:F

    .line 1455
    iget v0, p1, La/b/b/a/k$c;->f:F

    iput v0, p0, La/b/b/a/k$c;->f:F

    .line 1456
    iget v0, p1, La/b/b/a/k$c;->g:F

    iput v0, p0, La/b/b/a/k$c;->g:F

    .line 1457
    iget v0, p1, La/b/b/a/k$c;->h:F

    iput v0, p0, La/b/b/a/k$c;->h:F

    .line 1458
    iget v0, p1, La/b/b/a/k$c;->i:F

    iput v0, p0, La/b/b/a/k$c;->i:F

    .line 1459
    iget-object v0, p1, La/b/b/a/k$c;->l:[I

    iput-object v0, p0, La/b/b/a/k$c;->l:[I

    .line 1460
    iget-object v0, p1, La/b/b/a/k$c;->m:Ljava/lang/String;

    iput-object v0, p0, La/b/b/a/k$c;->m:Ljava/lang/String;

    .line 1461
    iget v0, p1, La/b/b/a/k$c;->k:I

    iput v0, p0, La/b/b/a/k$c;->k:I

    .line 1462
    iget-object v0, p0, La/b/b/a/k$c;->m:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 1463
    invoke-virtual {p2, v0, p0}, La/b/c/f/m;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1466
    :cond_0
    iget-object v0, p0, La/b/b/a/k$c;->j:Landroid/graphics/Matrix;

    iget-object v1, p1, La/b/b/a/k$c;->j:Landroid/graphics/Matrix;

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->set(Landroid/graphics/Matrix;)V

    .line 1468
    iget-object v0, p1, La/b/b/a/k$c;->b:Ljava/util/ArrayList;

    .line 1469
    .local v0, "children":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/support/graphics/drawable/VectorDrawableCompat$VObject;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v1, v2, :cond_5

    .line 1470
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    .line 1471
    .local v2, "copyChild":Ljava/lang/Object;
    instance-of v3, v2, La/b/b/a/k$c;

    if-eqz v3, :cond_1

    .line 1472
    move-object v3, v2

    check-cast v3, La/b/b/a/k$c;

    .line 1473
    .local v3, "copyGroup":La/b/b/a/k$c;
    iget-object v4, p0, La/b/b/a/k$c;->b:Ljava/util/ArrayList;

    new-instance v5, La/b/b/a/k$c;

    invoke-direct {v5, v3, p2}, La/b/b/a/k$c;-><init>(La/b/b/a/k$c;La/b/c/f/b;)V

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1474
    .end local v3    # "copyGroup":La/b/b/a/k$c;
    goto :goto_2

    .line 1476
    :cond_1
    instance-of v3, v2, La/b/b/a/k$b;

    if-eqz v3, :cond_2

    .line 1477
    new-instance v3, La/b/b/a/k$b;

    move-object v4, v2

    check-cast v4, La/b/b/a/k$b;

    invoke-direct {v3, v4}, La/b/b/a/k$b;-><init>(La/b/b/a/k$b;)V

    .local v3, "newPath":La/b/b/a/k$e;
    goto :goto_1

    .line 1478
    .end local v3    # "newPath":La/b/b/a/k$e;
    :cond_2
    instance-of v3, v2, La/b/b/a/k$a;

    if-eqz v3, :cond_4

    .line 1479
    new-instance v3, La/b/b/a/k$a;

    move-object v4, v2

    check-cast v4, La/b/b/a/k$a;

    invoke-direct {v3, v4}, La/b/b/a/k$a;-><init>(La/b/b/a/k$a;)V

    .line 1483
    .restart local v3    # "newPath":La/b/b/a/k$e;
    :goto_1
    iget-object v4, p0, La/b/b/a/k$c;->b:Ljava/util/ArrayList;

    invoke-virtual {v4, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1484
    iget-object v4, v3, La/b/b/a/k$e;->b:Ljava/lang/String;

    if-eqz v4, :cond_3

    .line 1485
    invoke-virtual {p2, v4, v3}, La/b/c/f/m;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1469
    .end local v2    # "copyChild":Ljava/lang/Object;
    .end local v3    # "newPath":La/b/b/a/k$e;
    :cond_3
    :goto_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 1481
    .restart local v2    # "copyChild":Ljava/lang/Object;
    :cond_4
    new-instance v3, Ljava/lang/IllegalStateException;

    const-string v4, "Unknown object in the tree!"

    invoke-direct {v3, v4}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 1489
    .end local v1    # "i":I
    .end local v2    # "copyChild":Ljava/lang/Object;
    :cond_5
    return-void
.end method

.method private a(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;)V
    .locals 3
    .param p1, "a"    # Landroid/content/res/TypedArray;
    .param p2, "parser"    # Lorg/xmlpull/v1/XmlPullParser;

    .line 1514
    const/4 v0, 0x0

    iput-object v0, p0, La/b/b/a/k$c;->l:[I

    .line 1517
    iget v0, p0, La/b/b/a/k$c;->c:F

    const-string v1, "rotation"

    const/4 v2, 0x5

    invoke-static {p1, p2, v1, v2, v0}, La/b/c/a/a/i;->a(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;IF)F

    move-result v0

    iput v0, p0, La/b/b/a/k$c;->c:F

    .line 1520
    iget v0, p0, La/b/b/a/k$c;->d:F

    const/4 v1, 0x1

    invoke-virtual {p1, v1, v0}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v0

    iput v0, p0, La/b/b/a/k$c;->d:F

    .line 1521
    iget v0, p0, La/b/b/a/k$c;->e:F

    const/4 v1, 0x2

    invoke-virtual {p1, v1, v0}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v0

    iput v0, p0, La/b/b/a/k$c;->e:F

    .line 1524
    iget v0, p0, La/b/b/a/k$c;->f:F

    const-string v1, "scaleX"

    const/4 v2, 0x3

    invoke-static {p1, p2, v1, v2, v0}, La/b/c/a/a/i;->a(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;IF)F

    move-result v0

    iput v0, p0, La/b/b/a/k$c;->f:F

    .line 1528
    iget v0, p0, La/b/b/a/k$c;->g:F

    const-string v1, "scaleY"

    const/4 v2, 0x4

    invoke-static {p1, p2, v1, v2, v0}, La/b/c/a/a/i;->a(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;IF)F

    move-result v0

    iput v0, p0, La/b/b/a/k$c;->g:F

    .line 1531
    iget v0, p0, La/b/b/a/k$c;->h:F

    const-string v1, "translateX"

    const/4 v2, 0x6

    invoke-static {p1, p2, v1, v2, v0}, La/b/c/a/a/i;->a(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;IF)F

    move-result v0

    iput v0, p0, La/b/b/a/k$c;->h:F

    .line 1533
    iget v0, p0, La/b/b/a/k$c;->i:F

    const-string v1, "translateY"

    const/4 v2, 0x7

    invoke-static {p1, p2, v1, v2, v0}, La/b/c/a/a/i;->a(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;IF)F

    move-result v0

    iput v0, p0, La/b/b/a/k$c;->i:F

    .line 1536
    nop

    .line 1537
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 1538
    .local v0, "groupName":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 1539
    iput-object v0, p0, La/b/b/a/k$c;->m:Ljava/lang/String;

    .line 1542
    :cond_0
    invoke-direct {p0}, La/b/b/a/k$c;->b()V

    .line 1543
    return-void
.end method

.method private b()V
    .locals 4

    .line 1548
    iget-object v0, p0, La/b/b/a/k$c;->j:Landroid/graphics/Matrix;

    invoke-virtual {v0}, Landroid/graphics/Matrix;->reset()V

    .line 1549
    iget-object v0, p0, La/b/b/a/k$c;->j:Landroid/graphics/Matrix;

    iget v1, p0, La/b/b/a/k$c;->d:F

    neg-float v1, v1

    iget v2, p0, La/b/b/a/k$c;->e:F

    neg-float v2, v2

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 1550
    iget-object v0, p0, La/b/b/a/k$c;->j:Landroid/graphics/Matrix;

    iget v1, p0, La/b/b/a/k$c;->f:F

    iget v2, p0, La/b/b/a/k$c;->g:F

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Matrix;->postScale(FF)Z

    .line 1551
    iget-object v0, p0, La/b/b/a/k$c;->j:Landroid/graphics/Matrix;

    iget v1, p0, La/b/b/a/k$c;->c:F

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2, v2}, Landroid/graphics/Matrix;->postRotate(FFF)Z

    .line 1552
    iget-object v0, p0, La/b/b/a/k$c;->j:Landroid/graphics/Matrix;

    iget v1, p0, La/b/b/a/k$c;->h:F

    iget v2, p0, La/b/b/a/k$c;->d:F

    add-float/2addr v1, v2

    iget v2, p0, La/b/b/a/k$c;->i:F

    iget v3, p0, La/b/b/a/k$c;->e:F

    add-float/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 1553
    return-void
.end method


# virtual methods
.method public a(Landroid/content/res/Resources;Landroid/util/AttributeSet;Landroid/content/res/Resources$Theme;Lorg/xmlpull/v1/XmlPullParser;)V
    .locals 1
    .param p1, "res"    # Landroid/content/res/Resources;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "theme"    # Landroid/content/res/Resources$Theme;
    .param p4, "parser"    # Lorg/xmlpull/v1/XmlPullParser;

    .line 1503
    sget-object v0, La/b/b/a/a;->b:[I

    invoke-static {p1, p3, p2, v0}, La/b/c/a/a/i;->a(Landroid/content/res/Resources;Landroid/content/res/Resources$Theme;Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 1505
    .local v0, "a":Landroid/content/res/TypedArray;
    invoke-direct {p0, v0, p4}, La/b/b/a/k$c;->a(Landroid/content/res/TypedArray;Lorg/xmlpull/v1/XmlPullParser;)V

    .line 1506
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 1507
    return-void
.end method

.method public a()Z
    .locals 2

    .line 1649
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, La/b/b/a/k$c;->b:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v0, v1, :cond_1

    .line 1650
    iget-object v1, p0, La/b/b/a/k$c;->b:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, La/b/b/a/k$d;

    invoke-virtual {v1}, La/b/b/a/k$d;->a()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1651
    const/4 v1, 0x1

    return v1

    .line 1649
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 1654
    .end local v0    # "i":I
    :cond_1
    const/4 v0, 0x0

    return v0
.end method

.method public a([I)Z
    .locals 3
    .param p1, "stateSet"    # [I

    .line 1659
    const/4 v0, 0x0

    .line 1660
    .local v0, "changed":Z
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, La/b/b/a/k$c;->b:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 1661
    iget-object v2, p0, La/b/b/a/k$c;->b:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, La/b/b/a/k$d;

    invoke-virtual {v2, p1}, La/b/b/a/k$d;->a([I)Z

    move-result v2

    or-int/2addr v0, v2

    .line 1660
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 1663
    .end local v1    # "i":I
    :cond_0
    return v0
.end method

.method public getGroupName()Ljava/lang/String;
    .locals 1

    .line 1495
    iget-object v0, p0, La/b/b/a/k$c;->m:Ljava/lang/String;

    return-object v0
.end method

.method public getLocalMatrix()Landroid/graphics/Matrix;
    .locals 1

    .line 1499
    iget-object v0, p0, La/b/b/a/k$c;->j:Landroid/graphics/Matrix;

    return-object v0
.end method

.method public getPivotX()F
    .locals 1

    .line 1571
    iget v0, p0, La/b/b/a/k$c;->d:F

    return v0
.end method

.method public getPivotY()F
    .locals 1

    .line 1584
    iget v0, p0, La/b/b/a/k$c;->e:F

    return v0
.end method

.method public getRotation()F
    .locals 1

    .line 1558
    iget v0, p0, La/b/b/a/k$c;->c:F

    return v0
.end method

.method public getScaleX()F
    .locals 1

    .line 1597
    iget v0, p0, La/b/b/a/k$c;->f:F

    return v0
.end method

.method public getScaleY()F
    .locals 1

    .line 1610
    iget v0, p0, La/b/b/a/k$c;->g:F

    return v0
.end method

.method public getTranslateX()F
    .locals 1

    .line 1623
    iget v0, p0, La/b/b/a/k$c;->h:F

    return v0
.end method

.method public getTranslateY()F
    .locals 1

    .line 1636
    iget v0, p0, La/b/b/a/k$c;->i:F

    return v0
.end method

.method public setPivotX(F)V
    .locals 1
    .param p1, "pivotX"    # F

    .line 1576
    iget v0, p0, La/b/b/a/k$c;->d:F

    cmpl-float v0, p1, v0

    if-eqz v0, :cond_0

    .line 1577
    iput p1, p0, La/b/b/a/k$c;->d:F

    .line 1578
    invoke-direct {p0}, La/b/b/a/k$c;->b()V

    .line 1580
    :cond_0
    return-void
.end method

.method public setPivotY(F)V
    .locals 1
    .param p1, "pivotY"    # F

    .line 1589
    iget v0, p0, La/b/b/a/k$c;->e:F

    cmpl-float v0, p1, v0

    if-eqz v0, :cond_0

    .line 1590
    iput p1, p0, La/b/b/a/k$c;->e:F

    .line 1591
    invoke-direct {p0}, La/b/b/a/k$c;->b()V

    .line 1593
    :cond_0
    return-void
.end method

.method public setRotation(F)V
    .locals 1
    .param p1, "rotation"    # F

    .line 1563
    iget v0, p0, La/b/b/a/k$c;->c:F

    cmpl-float v0, p1, v0

    if-eqz v0, :cond_0

    .line 1564
    iput p1, p0, La/b/b/a/k$c;->c:F

    .line 1565
    invoke-direct {p0}, La/b/b/a/k$c;->b()V

    .line 1567
    :cond_0
    return-void
.end method

.method public setScaleX(F)V
    .locals 1
    .param p1, "scaleX"    # F

    .line 1602
    iget v0, p0, La/b/b/a/k$c;->f:F

    cmpl-float v0, p1, v0

    if-eqz v0, :cond_0

    .line 1603
    iput p1, p0, La/b/b/a/k$c;->f:F

    .line 1604
    invoke-direct {p0}, La/b/b/a/k$c;->b()V

    .line 1606
    :cond_0
    return-void
.end method

.method public setScaleY(F)V
    .locals 1
    .param p1, "scaleY"    # F

    .line 1615
    iget v0, p0, La/b/b/a/k$c;->g:F

    cmpl-float v0, p1, v0

    if-eqz v0, :cond_0

    .line 1616
    iput p1, p0, La/b/b/a/k$c;->g:F

    .line 1617
    invoke-direct {p0}, La/b/b/a/k$c;->b()V

    .line 1619
    :cond_0
    return-void
.end method

.method public setTranslateX(F)V
    .locals 1
    .param p1, "translateX"    # F

    .line 1628
    iget v0, p0, La/b/b/a/k$c;->h:F

    cmpl-float v0, p1, v0

    if-eqz v0, :cond_0

    .line 1629
    iput p1, p0, La/b/b/a/k$c;->h:F

    .line 1630
    invoke-direct {p0}, La/b/b/a/k$c;->b()V

    .line 1632
    :cond_0
    return-void
.end method

.method public setTranslateY(F)V
    .locals 1
    .param p1, "translateY"    # F

    .line 1641
    iget v0, p0, La/b/b/a/k$c;->i:F

    cmpl-float v0, p1, v0

    if-eqz v0, :cond_0

    .line 1642
    iput p1, p0, La/b/b/a/k$c;->i:F

    .line 1643
    invoke-direct {p0}, La/b/b/a/k$c;->b()V

    .line 1645
    :cond_0
    return-void
.end method
