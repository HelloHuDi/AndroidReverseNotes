.class public Landroid/support/v4/app/i;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/content/ComponentCallbacks;
.implements Landroid/view/View$OnCreateContextMenuListener;
.implements Landroid/arch/lifecycle/f;
.implements Landroid/arch/lifecycle/t;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroid/support/v4/app/i$a;,
        Landroid/support/v4/app/i$c;,
        Landroid/support/v4/app/i$b;
    }
.end annotation


# static fields
.field private static final a:La/b/c/f/m;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "La/b/c/f/m<",
            "Ljava/lang/String;",
            "Ljava/lang/Class<",
            "*>;>;"
        }
    .end annotation
.end field

.field static final b:Ljava/lang/Object;


# instance fields
.field A:I

.field B:Ljava/lang/String;

.field C:Z

.field D:Z

.field E:Z

.field F:Z

.field G:Z

.field H:Z

.field I:Z

.field J:Landroid/view/ViewGroup;

.field K:Landroid/view/View;

.field L:Landroid/view/View;

.field M:Z

.field N:Z

.field O:Landroid/support/v4/app/i$a;

.field P:Z

.field Q:Z

.field R:F

.field S:Landroid/view/LayoutInflater;

.field T:Z

.field U:Landroid/arch/lifecycle/h;

.field V:Landroid/arch/lifecycle/h;

.field W:Landroid/arch/lifecycle/f;

.field X:Landroid/arch/lifecycle/m;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/arch/lifecycle/m<",
            "Landroid/arch/lifecycle/f;",
            ">;"
        }
    .end annotation
.end field

.field c:I

.field d:Landroid/os/Bundle;

.field e:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray<",
            "Landroid/os/Parcelable;",
            ">;"
        }
    .end annotation
.end field

.field f:Ljava/lang/Boolean;

.field g:I

.field h:Ljava/lang/String;

.field i:Landroid/os/Bundle;

.field j:Landroid/support/v4/app/i;

.field k:I

.field l:I

.field m:Z

.field n:Z

.field o:Z

.field p:Z

.field q:Z

.field r:Z

.field s:I

.field t:Landroid/support/v4/app/v;

.field u:Landroid/support/v4/app/n;

.field v:Landroid/support/v4/app/v;

.field w:Landroid/support/v4/app/w;

.field x:Landroid/arch/lifecycle/s;

.field y:Landroid/support/v4/app/i;

.field z:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 87
    new-instance v0, La/b/c/f/m;

    invoke-direct {v0}, La/b/c/f/m;-><init>()V

    sput-object v0, Landroid/support/v4/app/i;->a:La/b/c/f/m;

    .line 90
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Landroid/support/v4/app/i;->b:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .line 410
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 98
    const/4 v0, 0x0

    iput v0, p0, Landroid/support/v4/app/i;->c:I

    .line 108
    const/4 v0, -0x1

    iput v0, p0, Landroid/support/v4/app/i;->g:I

    .line 120
    iput v0, p0, Landroid/support/v4/app/i;->k:I

    .line 199
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/i;->H:Z

    .line 218
    iput-boolean v0, p0, Landroid/support/v4/app/i;->N:Z

    .line 247
    new-instance v0, Landroid/arch/lifecycle/h;

    invoke-direct {v0, p0}, Landroid/arch/lifecycle/h;-><init>(Landroid/arch/lifecycle/f;)V

    iput-object v0, p0, Landroid/support/v4/app/i;->U:Landroid/arch/lifecycle/h;

    .line 254
    new-instance v0, Landroid/arch/lifecycle/m;

    invoke-direct {v0}, Landroid/arch/lifecycle/m;-><init>()V

    iput-object v0, p0, Landroid/support/v4/app/i;->X:Landroid/arch/lifecycle/m;

    .line 411
    return-void
.end method

.method private Z()Landroid/support/v4/app/i$a;
    .locals 1

    .line 2747
    iget-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    if-nez v0, :cond_0

    .line 2748
    new-instance v0, Landroid/support/v4/app/i$a;

    invoke-direct {v0}, Landroid/support/v4/app/i$a;-><init>()V

    iput-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    .line 2750
    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    return-object v0
.end method

.method public static a(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/support/v4/app/i;
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "fname"    # Ljava/lang/String;
    .param p2, "args"    # Landroid/os/Bundle;

    .line 437
    const-string v0, " empty constructor that is public"

    const-string v1, ": make sure class name exists, is public, and has an"

    const-string v2, "Unable to instantiate fragment "

    :try_start_0
    sget-object v3, Landroid/support/v4/app/i;->a:La/b/c/f/m;

    invoke-virtual {v3, p1}, La/b/c/f/m;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Class;

    .line 438
    .local v3, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-nez v3, :cond_0

    .line 440
    invoke-virtual {p0}, Landroid/content/Context;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v4

    move-object v3, v4

    .line 441
    sget-object v4, Landroid/support/v4/app/i;->a:La/b/c/f/m;

    invoke-virtual {v4, p1, v3}, La/b/c/f/m;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 443
    :cond_0
    const/4 v4, 0x0

    new-array v5, v4, [Ljava/lang/Class;

    invoke-virtual {v3, v5}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v5

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v5, v4}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/support/v4/app/i;

    .line 444
    .local v4, "f":Landroid/support/v4/app/i;
    if-eqz p2, :cond_1

    .line 445
    invoke-virtual {v4}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v5

    invoke-virtual {p2, v5}, Landroid/os/Bundle;->setClassLoader(Ljava/lang/ClassLoader;)V

    .line 446
    invoke-virtual {v4, p2}, Landroid/support/v4/app/i;->m(Landroid/os/Bundle;)V
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_4
    .catch Ljava/lang/InstantiationException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_0

    .line 448
    :cond_1
    return-object v4

    .line 464
    .end local v3    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    .end local v4    # "f":Landroid/support/v4/app/i;
    :catch_0
    move-exception v0

    .line 465
    .local v0, "e":Ljava/lang/reflect/InvocationTargetException;
    new-instance v1, Landroid/support/v4/app/i$b;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, ": calling Fragment constructor caused an exception"

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Landroid/support/v4/app/i$b;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw v1

    .line 461
    .end local v0    # "e":Ljava/lang/reflect/InvocationTargetException;
    :catch_1
    move-exception v0

    .line 462
    .local v0, "e":Ljava/lang/NoSuchMethodException;
    new-instance v1, Landroid/support/v4/app/i$b;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, ": could not find Fragment constructor"

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Landroid/support/v4/app/i$b;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw v1

    .line 457
    .end local v0    # "e":Ljava/lang/NoSuchMethodException;
    :catch_2
    move-exception v3

    .line 458
    .local v3, "e":Ljava/lang/IllegalAccessException;
    new-instance v4, Landroid/support/v4/app/i$b;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v4, v0, v3}, Landroid/support/v4/app/i$b;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw v4

    .line 453
    .end local v3    # "e":Ljava/lang/IllegalAccessException;
    :catch_3
    move-exception v3

    .line 454
    .local v3, "e":Ljava/lang/InstantiationException;
    new-instance v4, Landroid/support/v4/app/i$b;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v4, v0, v3}, Landroid/support/v4/app/i$b;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw v4

    .line 449
    .end local v3    # "e":Ljava/lang/InstantiationException;
    :catch_4
    move-exception v3

    .line 450
    .local v3, "e":Ljava/lang/ClassNotFoundException;
    new-instance v4, Landroid/support/v4/app/i$b;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v4, v0, v3}, Landroid/support/v4/app/i$b;-><init>(Ljava/lang/String;Ljava/lang/Exception;)V

    throw v4
.end method

.method static a(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "fname"    # Ljava/lang/String;

    .line 480
    :try_start_0
    sget-object v0, Landroid/support/v4/app/i;->a:La/b/c/f/m;

    invoke-virtual {v0, p1}, La/b/c/f/m;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Class;

    .line 481
    .local v0, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-nez v0, :cond_0

    .line 483
    invoke-virtual {p0}, Landroid/content/Context;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    move-object v0, v1

    .line 484
    sget-object v1, Landroid/support/v4/app/i;->a:La/b/c/f/m;

    invoke-virtual {v1, p1, v0}, La/b/c/f/m;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 486
    :cond_0
    const-class v1, Landroid/support/v4/app/i;

    invoke-virtual {v1, v0}, Ljava/lang/Class;->isAssignableFrom(Ljava/lang/Class;)Z

    move-result v1
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    return v1

    .line 487
    .end local v0    # "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    :catch_0
    move-exception v0

    .line 488
    .local v0, "e":Ljava/lang/ClassNotFoundException;
    const/4 v1, 0x0

    return v1
.end method


# virtual methods
.method A()V
    .locals 3

    .line 2382
    iget-object v0, p0, Landroid/support/v4/app/i;->u:Landroid/support/v4/app/n;

    if-eqz v0, :cond_0

    .line 2385
    new-instance v0, Landroid/support/v4/app/v;

    invoke-direct {v0}, Landroid/support/v4/app/v;-><init>()V

    iput-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    .line 2386
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    iget-object v1, p0, Landroid/support/v4/app/i;->u:Landroid/support/v4/app/n;

    new-instance v2, Landroid/support/v4/app/g;

    invoke-direct {v2, p0}, Landroid/support/v4/app/g;-><init>(Landroid/support/v4/app/i;)V

    invoke-virtual {v0, v1, v2, p0}, Landroid/support/v4/app/v;->a(Landroid/support/v4/app/n;Landroid/support/v4/app/l;Landroid/support/v4/app/i;)V

    .line 2406
    return-void

    .line 2383
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Fragment has not been attached yet."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method B()Z
    .locals 1

    .line 2845
    iget-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    if-nez v0, :cond_0

    .line 2846
    const/4 v0, 0x0

    return v0

    .line 2848
    :cond_0
    iget-boolean v0, v0, Landroid/support/v4/app/i$a;->s:Z

    return v0
.end method

.method final C()Z
    .locals 1

    .line 518
    iget v0, p0, Landroid/support/v4/app/i;->s:I

    if-lez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method D()Z
    .locals 1

    .line 2838
    iget-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    if-nez v0, :cond_0

    .line 2839
    const/4 v0, 0x0

    return v0

    .line 2841
    :cond_0
    iget-boolean v0, v0, Landroid/support/v4/app/i$a;->q:Z

    return v0
.end method

.method public final E()Z
    .locals 1

    .line 604
    iget-object v0, p0, Landroid/support/v4/app/i;->t:Landroid/support/v4/app/v;

    if-nez v0, :cond_0

    .line 605
    const/4 v0, 0x0

    return v0

    .line 607
    :cond_0
    invoke-virtual {v0}, Landroid/support/v4/app/v;->b()Z

    move-result v0

    return v0
.end method

.method F()V
    .locals 1

    .line 2514
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v0, :cond_0

    .line 2515
    invoke-virtual {v0}, Landroid/support/v4/app/v;->q()V

    .line 2517
    :cond_0
    return-void
.end method

.method public G()V
    .locals 3

    .line 1728
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    .line 1729
    invoke-virtual {p0}, Landroid/support/v4/app/i;->d()Landroid/support/v4/app/k;

    move-result-object v1

    .line 1730
    .local v1, "activity":Landroid/support/v4/app/k;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Landroid/app/Activity;->isChangingConfigurations()Z

    move-result v2

    if-eqz v2, :cond_0

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    .line 1731
    .local v0, "isChangingConfigurations":Z
    :goto_0
    iget-object v2, p0, Landroid/support/v4/app/i;->x:Landroid/arch/lifecycle/s;

    if-eqz v2, :cond_1

    if-nez v0, :cond_1

    .line 1732
    invoke-virtual {v2}, Landroid/arch/lifecycle/s;->a()V

    .line 1734
    :cond_1
    return-void
.end method

.method public H()V
    .locals 0

    .line 1812
    return-void
.end method

.method public I()V
    .locals 1

    .line 1719
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    .line 1720
    return-void
.end method

.method public J()V
    .locals 1

    .line 1768
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    .line 1769
    return-void
.end method

.method public K()V
    .locals 1

    .line 1689
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    .line 1690
    return-void
.end method

.method public L()V
    .locals 1

    .line 1632
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    .line 1633
    return-void
.end method

.method public M()V
    .locals 1

    .line 1621
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    .line 1622
    return-void
.end method

.method public N()V
    .locals 1

    .line 1699
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    .line 1700
    return-void
.end method

.method O()Landroid/support/v4/app/o;
    .locals 1

    .line 865
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    return-object v0
.end method

.method P()V
    .locals 3

    .line 2692
    iget-object v0, p0, Landroid/support/v4/app/i;->U:Landroid/arch/lifecycle/h;

    sget-object v1, Landroid/arch/lifecycle/d$a;->ON_DESTROY:Landroid/arch/lifecycle/d$a;

    invoke-virtual {v0, v1}, Landroid/arch/lifecycle/h;->b(Landroid/arch/lifecycle/d$a;)V

    .line 2693
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v0, :cond_0

    .line 2694
    invoke-virtual {v0}, Landroid/support/v4/app/v;->f()V

    .line 2696
    :cond_0
    const/4 v0, 0x0

    iput v0, p0, Landroid/support/v4/app/i;->c:I

    .line 2697
    iput-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    .line 2698
    iput-boolean v0, p0, Landroid/support/v4/app/i;->T:Z

    .line 2699
    invoke-virtual {p0}, Landroid/support/v4/app/i;->G()V

    .line 2700
    iget-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    if-eqz v0, :cond_1

    .line 2704
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    .line 2705
    return-void

    .line 2701
    :cond_1
    new-instance v0, Landroid/support/v4/app/W;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Fragment "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v2, " did not call through to super.onDestroy()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/support/v4/app/W;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method Q()V
    .locals 3

    .line 2670
    iget-object v0, p0, Landroid/support/v4/app/i;->K:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 2671
    iget-object v0, p0, Landroid/support/v4/app/i;->V:Landroid/arch/lifecycle/h;

    sget-object v1, Landroid/arch/lifecycle/d$a;->ON_DESTROY:Landroid/arch/lifecycle/d$a;

    invoke-virtual {v0, v1}, Landroid/arch/lifecycle/h;->b(Landroid/arch/lifecycle/d$a;)V

    .line 2673
    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v0, :cond_1

    .line 2674
    invoke-virtual {v0}, Landroid/support/v4/app/v;->g()V

    .line 2676
    :cond_1
    const/4 v0, 0x1

    iput v0, p0, Landroid/support/v4/app/i;->c:I

    .line 2677
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    .line 2678
    invoke-virtual {p0}, Landroid/support/v4/app/i;->I()V

    .line 2679
    iget-boolean v1, p0, Landroid/support/v4/app/i;->I:Z

    if-eqz v1, :cond_2

    .line 2687
    invoke-static {p0}, Landroid/support/v4/app/Q;->a(Landroid/arch/lifecycle/f;)Landroid/support/v4/app/Q;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/Q;->a()V

    .line 2688
    iput-boolean v0, p0, Landroid/support/v4/app/i;->r:Z

    .line 2689
    return-void

    .line 2680
    :cond_2
    new-instance v0, Landroid/support/v4/app/W;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Fragment "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v2, " did not call through to super.onDestroyView()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/support/v4/app/W;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method R()V
    .locals 3

    .line 2708
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    .line 2709
    invoke-virtual {p0}, Landroid/support/v4/app/i;->J()V

    .line 2710
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v4/app/i;->S:Landroid/view/LayoutInflater;

    .line 2711
    iget-boolean v1, p0, Landroid/support/v4/app/i;->I:Z

    if-eqz v1, :cond_2

    .line 2719
    iget-object v1, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v1, :cond_1

    .line 2720
    iget-boolean v2, p0, Landroid/support/v4/app/i;->F:Z

    if-eqz v2, :cond_0

    .line 2724
    invoke-virtual {v1}, Landroid/support/v4/app/v;->f()V

    .line 2725
    iput-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    goto :goto_0

    .line 2721
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Child FragmentManager of "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v2, " was not "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, " destroyed and this fragment is not retaining instance"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 2727
    :cond_1
    :goto_0
    return-void

    .line 2712
    :cond_2
    new-instance v0, Landroid/support/v4/app/W;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Fragment "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v2, " did not call through to super.onDetach()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/support/v4/app/W;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method S()V
    .locals 1

    .line 2541
    invoke-virtual {p0}, Landroid/support/v4/app/i;->onLowMemory()V

    .line 2542
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v0, :cond_0

    .line 2543
    invoke-virtual {v0}, Landroid/support/v4/app/v;->h()V

    .line 2545
    :cond_0
    return-void
.end method

.method T()V
    .locals 3

    .line 2636
    iget-object v0, p0, Landroid/support/v4/app/i;->K:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 2637
    iget-object v0, p0, Landroid/support/v4/app/i;->V:Landroid/arch/lifecycle/h;

    sget-object v1, Landroid/arch/lifecycle/d$a;->ON_PAUSE:Landroid/arch/lifecycle/d$a;

    invoke-virtual {v0, v1}, Landroid/arch/lifecycle/h;->b(Landroid/arch/lifecycle/d$a;)V

    .line 2639
    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/i;->U:Landroid/arch/lifecycle/h;

    sget-object v1, Landroid/arch/lifecycle/d$a;->ON_PAUSE:Landroid/arch/lifecycle/d$a;

    invoke-virtual {v0, v1}, Landroid/arch/lifecycle/h;->b(Landroid/arch/lifecycle/d$a;)V

    .line 2640
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v0, :cond_1

    .line 2641
    invoke-virtual {v0}, Landroid/support/v4/app/v;->i()V

    .line 2643
    :cond_1
    const/4 v0, 0x3

    iput v0, p0, Landroid/support/v4/app/i;->c:I

    .line 2644
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    .line 2645
    invoke-virtual {p0}, Landroid/support/v4/app/i;->K()V

    .line 2646
    iget-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    if-eqz v0, :cond_2

    .line 2650
    return-void

    .line 2647
    :cond_2
    new-instance v0, Landroid/support/v4/app/W;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Fragment "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v2, " did not call through to super.onPause()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/support/v4/app/W;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method U()V
    .locals 3

    .line 2492
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v0, :cond_0

    .line 2493
    invoke-virtual {v0}, Landroid/support/v4/app/v;->q()V

    .line 2494
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    invoke-virtual {v0}, Landroid/support/v4/app/v;->n()Z

    .line 2496
    :cond_0
    const/4 v0, 0x4

    iput v0, p0, Landroid/support/v4/app/i;->c:I

    .line 2497
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    .line 2498
    invoke-virtual {p0}, Landroid/support/v4/app/i;->L()V

    .line 2499
    iget-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    if-eqz v0, :cond_3

    .line 2503
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v0, :cond_1

    .line 2504
    invoke-virtual {v0}, Landroid/support/v4/app/v;->j()V

    .line 2505
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    invoke-virtual {v0}, Landroid/support/v4/app/v;->n()Z

    .line 2507
    :cond_1
    iget-object v0, p0, Landroid/support/v4/app/i;->U:Landroid/arch/lifecycle/h;

    sget-object v1, Landroid/arch/lifecycle/d$a;->ON_RESUME:Landroid/arch/lifecycle/d$a;

    invoke-virtual {v0, v1}, Landroid/arch/lifecycle/h;->b(Landroid/arch/lifecycle/d$a;)V

    .line 2508
    iget-object v0, p0, Landroid/support/v4/app/i;->K:Landroid/view/View;

    if-eqz v0, :cond_2

    .line 2509
    iget-object v0, p0, Landroid/support/v4/app/i;->V:Landroid/arch/lifecycle/h;

    sget-object v1, Landroid/arch/lifecycle/d$a;->ON_RESUME:Landroid/arch/lifecycle/d$a;

    invoke-virtual {v0, v1}, Landroid/arch/lifecycle/h;->b(Landroid/arch/lifecycle/d$a;)V

    .line 2511
    :cond_2
    return-void

    .line 2500
    :cond_3
    new-instance v0, Landroid/support/v4/app/W;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Fragment "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v2, " did not call through to super.onResume()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/support/v4/app/W;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method V()V
    .locals 3

    .line 2471
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v0, :cond_0

    .line 2472
    invoke-virtual {v0}, Landroid/support/v4/app/v;->q()V

    .line 2473
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    invoke-virtual {v0}, Landroid/support/v4/app/v;->n()Z

    .line 2475
    :cond_0
    const/4 v0, 0x3

    iput v0, p0, Landroid/support/v4/app/i;->c:I

    .line 2476
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    .line 2477
    invoke-virtual {p0}, Landroid/support/v4/app/i;->M()V

    .line 2478
    iget-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    if-eqz v0, :cond_3

    .line 2482
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v0, :cond_1

    .line 2483
    invoke-virtual {v0}, Landroid/support/v4/app/v;->k()V

    .line 2485
    :cond_1
    iget-object v0, p0, Landroid/support/v4/app/i;->U:Landroid/arch/lifecycle/h;

    sget-object v1, Landroid/arch/lifecycle/d$a;->ON_START:Landroid/arch/lifecycle/d$a;

    invoke-virtual {v0, v1}, Landroid/arch/lifecycle/h;->b(Landroid/arch/lifecycle/d$a;)V

    .line 2486
    iget-object v0, p0, Landroid/support/v4/app/i;->K:Landroid/view/View;

    if-eqz v0, :cond_2

    .line 2487
    iget-object v0, p0, Landroid/support/v4/app/i;->V:Landroid/arch/lifecycle/h;

    sget-object v1, Landroid/arch/lifecycle/d$a;->ON_START:Landroid/arch/lifecycle/d$a;

    invoke-virtual {v0, v1}, Landroid/arch/lifecycle/h;->b(Landroid/arch/lifecycle/d$a;)V

    .line 2489
    :cond_2
    return-void

    .line 2479
    :cond_3
    new-instance v0, Landroid/support/v4/app/W;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Fragment "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v2, " did not call through to super.onStart()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/support/v4/app/W;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method W()V
    .locals 3

    .line 2653
    iget-object v0, p0, Landroid/support/v4/app/i;->K:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 2654
    iget-object v0, p0, Landroid/support/v4/app/i;->V:Landroid/arch/lifecycle/h;

    sget-object v1, Landroid/arch/lifecycle/d$a;->ON_STOP:Landroid/arch/lifecycle/d$a;

    invoke-virtual {v0, v1}, Landroid/arch/lifecycle/h;->b(Landroid/arch/lifecycle/d$a;)V

    .line 2656
    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/i;->U:Landroid/arch/lifecycle/h;

    sget-object v1, Landroid/arch/lifecycle/d$a;->ON_STOP:Landroid/arch/lifecycle/d$a;

    invoke-virtual {v0, v1}, Landroid/arch/lifecycle/h;->b(Landroid/arch/lifecycle/d$a;)V

    .line 2657
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v0, :cond_1

    .line 2658
    invoke-virtual {v0}, Landroid/support/v4/app/v;->l()V

    .line 2660
    :cond_1
    const/4 v0, 0x2

    iput v0, p0, Landroid/support/v4/app/i;->c:I

    .line 2661
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    .line 2662
    invoke-virtual {p0}, Landroid/support/v4/app/i;->N()V

    .line 2663
    iget-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    if-eqz v0, :cond_2

    .line 2667
    return-void

    .line 2664
    :cond_2
    new-instance v0, Landroid/support/v4/app/W;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Fragment "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v2, " did not call through to super.onStop()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/support/v4/app/W;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public final X()Landroid/content/Context;
    .locals 4

    .line 694
    invoke-virtual {p0}, Landroid/support/v4/app/i;->j()Landroid/content/Context;

    move-result-object v0

    .line 695
    .local v0, "context":Landroid/content/Context;
    if-eqz v0, :cond_0

    .line 698
    return-object v0

    .line 696
    :cond_0
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Fragment "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v3, " not attached to a context."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public Y()V
    .locals 2

    .line 2252
    iget-object v0, p0, Landroid/support/v4/app/i;->t:Landroid/support/v4/app/v;

    if-eqz v0, :cond_2

    iget-object v0, v0, Landroid/support/v4/app/v;->s:Landroid/support/v4/app/n;

    if-nez v0, :cond_0

    goto :goto_0

    .line 2254
    :cond_0
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    iget-object v1, p0, Landroid/support/v4/app/i;->t:Landroid/support/v4/app/v;

    iget-object v1, v1, Landroid/support/v4/app/v;->s:Landroid/support/v4/app/n;

    invoke-virtual {v1}, Landroid/support/v4/app/n;->e()Landroid/os/Handler;

    move-result-object v1

    invoke-virtual {v1}, Landroid/os/Handler;->getLooper()Landroid/os/Looper;

    move-result-object v1

    if-eq v0, v1, :cond_1

    .line 2255
    iget-object v0, p0, Landroid/support/v4/app/i;->t:Landroid/support/v4/app/v;

    iget-object v0, v0, Landroid/support/v4/app/v;->s:Landroid/support/v4/app/n;

    invoke-virtual {v0}, Landroid/support/v4/app/n;->e()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Landroid/support/v4/app/f;

    invoke-direct {v1, p0}, Landroid/support/v4/app/f;-><init>(Landroid/support/v4/app/i;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->postAtFrontOfQueue(Ljava/lang/Runnable;)Z

    goto :goto_1

    .line 2262
    :cond_1
    invoke-virtual {p0}, Landroid/support/v4/app/i;->c()V

    goto :goto_1

    .line 2253
    :cond_2
    :goto_0
    invoke-direct {p0}, Landroid/support/v4/app/i;->Z()Landroid/support/v4/app/i$a;

    move-result-object v0

    const/4 v1, 0x0

    iput-boolean v1, v0, Landroid/support/v4/app/i$a;->q:Z

    .line 2264
    :goto_1
    return-void
.end method

.method public a()Landroid/arch/lifecycle/d;
    .locals 1

    .line 258
    iget-object v0, p0, Landroid/support/v4/app/i;->U:Landroid/arch/lifecycle/h;

    return-object v0
.end method

.method a(Ljava/lang/String;)Landroid/support/v4/app/i;
    .locals 1
    .param p1, "who"    # Ljava/lang/String;

    .line 2372
    iget-object v0, p0, Landroid/support/v4/app/i;->h:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2373
    return-object p0

    .line 2375
    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v0, :cond_1

    .line 2376
    invoke-virtual {v0, p1}, Landroid/support/v4/app/v;->b(Ljava/lang/String;)Landroid/support/v4/app/i;

    move-result-object v0

    return-object v0

    .line 2378
    :cond_1
    const/4 v0, 0x0

    return-object v0
.end method

.method public a(Landroid/os/Bundle;)Landroid/view/LayoutInflater;
    .locals 2
    .param p1, "savedFragmentState"    # Landroid/os/Bundle;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 1326
    iget-object v0, p0, Landroid/support/v4/app/i;->u:Landroid/support/v4/app/n;

    if-eqz v0, :cond_0

    .line 1330
    invoke-virtual {v0}, Landroid/support/v4/app/n;->f()Landroid/view/LayoutInflater;

    move-result-object v0

    .line 1331
    .local v0, "result":Landroid/view/LayoutInflater;
    invoke-virtual {p0}, Landroid/support/v4/app/i;->i()Landroid/support/v4/app/o;

    .line 1332
    iget-object v1, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    invoke-virtual {v1}, Landroid/support/v4/app/v;->o()Landroid/view/LayoutInflater$Factory2;

    invoke-static {v0, v1}, La/b/c/g/h;->a(Landroid/view/LayoutInflater;Landroid/view/LayoutInflater$Factory2;)V

    .line 1333
    return-object v0

    .line 1327
    .end local v0    # "result":Landroid/view/LayoutInflater;
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public a(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 1
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .line 1553
    const/4 v0, 0x0

    return-object v0
.end method

.method public a(IZI)Landroid/view/animation/Animation;
    .locals 1
    .param p1, "transit"    # I
    .param p2, "enter"    # Z
    .param p3, "nextAnim"    # I

    .line 1454
    const/4 v0, 0x0

    return-object v0
.end method

.method a(I)V
    .locals 1
    .param p1, "animResourceId"    # I

    .line 2761
    iget-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    if-nez v0, :cond_0

    if-nez p1, :cond_0

    .line 2762
    return-void

    .line 2764
    :cond_0
    invoke-direct {p0}, Landroid/support/v4/app/i;->Z()Landroid/support/v4/app/i$a;

    move-result-object v0

    iput p1, v0, Landroid/support/v4/app/i$a;->d:I

    .line 2765
    return-void
.end method

.method a(II)V
    .locals 1
    .param p1, "nextTransition"    # I
    .param p2, "nextTransitionStyle"    # I

    .line 2775
    iget-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    if-nez v0, :cond_0

    if-nez p1, :cond_0

    if-nez p2, :cond_0

    .line 2776
    return-void

    .line 2778
    :cond_0
    invoke-direct {p0}, Landroid/support/v4/app/i;->Z()Landroid/support/v4/app/i$a;

    .line 2779
    iget-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    iput p1, v0, Landroid/support/v4/app/i$a;->e:I

    .line 2780
    iput p2, v0, Landroid/support/v4/app/i$a;->f:I

    .line 2781
    return-void
.end method

.method public a(IILandroid/content/Intent;)V
    .locals 0
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .line 1135
    return-void
.end method

.method final a(ILandroid/support/v4/app/i;)V
    .locals 2
    .param p1, "index"    # I
    .param p2, "parent"    # Landroid/support/v4/app/i;

    .line 509
    iput p1, p0, Landroid/support/v4/app/i;->g:I

    .line 510
    if-eqz p2, :cond_0

    .line 511
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p2, Landroid/support/v4/app/i;->h:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Landroid/support/v4/app/i;->g:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/app/i;->h:Ljava/lang/String;

    goto :goto_0

    .line 513
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "android:fragment:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget v1, p0, Landroid/support/v4/app/i;->g:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Landroid/support/v4/app/i;->h:Ljava/lang/String;

    .line 515
    :goto_0
    return-void
.end method

.method public a(I[Ljava/lang/String;[I)V
    .locals 0
    .param p1, "requestCode"    # I
    .param p2, "permissions"    # [Ljava/lang/String;
    .param p3, "grantResults"    # [I

    .line 1237
    return-void
.end method

.method a(Landroid/animation/Animator;)V
    .locals 1
    .param p1, "animator"    # Landroid/animation/Animator;

    .line 2816
    invoke-direct {p0}, Landroid/support/v4/app/i;->Z()Landroid/support/v4/app/i$a;

    move-result-object v0

    iput-object p1, v0, Landroid/support/v4/app/i$a;->b:Landroid/animation/Animator;

    .line 2817
    return-void
.end method

.method public a(Landroid/app/Activity;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 1435
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    .line 1436
    return-void
.end method

.method public a(Landroid/app/Activity;Landroid/util/AttributeSet;Landroid/os/Bundle;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .line 1397
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    .line 1398
    return-void
.end method

.method public a(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .line 1418
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    .line 1419
    iget-object v0, p0, Landroid/support/v4/app/i;->u:Landroid/support/v4/app/n;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    goto :goto_0

    :cond_0
    invoke-virtual {v0}, Landroid/support/v4/app/n;->b()Landroid/app/Activity;

    move-result-object v0

    .line 1420
    .local v0, "hostActivity":Landroid/app/Activity;
    :goto_0
    if-eqz v0, :cond_1

    .line 1421
    const/4 v1, 0x0

    iput-boolean v1, p0, Landroid/support/v4/app/i;->I:Z

    .line 1422
    invoke-virtual {p0, v0}, Landroid/support/v4/app/i;->a(Landroid/app/Activity;)V

    .line 1424
    :cond_1
    return-void
.end method

.method public a(Landroid/content/Context;Landroid/util/AttributeSet;Landroid/os/Bundle;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .line 1380
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    .line 1381
    iget-object v0, p0, Landroid/support/v4/app/i;->u:Landroid/support/v4/app/n;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    goto :goto_0

    :cond_0
    invoke-virtual {v0}, Landroid/support/v4/app/n;->b()Landroid/app/Activity;

    move-result-object v0

    .line 1382
    .local v0, "hostActivity":Landroid/app/Activity;
    :goto_0
    if-eqz v0, :cond_1

    .line 1383
    const/4 v1, 0x0

    iput-boolean v1, p0, Landroid/support/v4/app/i;->I:Z

    .line 1384
    invoke-virtual {p0, v0, p2, p3}, Landroid/support/v4/app/i;->a(Landroid/app/Activity;Landroid/util/AttributeSet;Landroid/os/Bundle;)V

    .line 1386
    :cond_1
    return-void
.end method

.method a(Landroid/content/res/Configuration;)V
    .locals 1
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .line 2534
    invoke-virtual {p0, p1}, Landroid/support/v4/app/i;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 2535
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v0, :cond_0

    .line 2536
    invoke-virtual {v0, p1}, Landroid/support/v4/app/v;->a(Landroid/content/res/Configuration;)V

    .line 2538
    :cond_0
    return-void
.end method

.method a(Landroid/support/v4/app/i$c;)V
    .locals 3
    .param p1, "listener"    # Landroid/support/v4/app/i$c;

    .line 2730
    invoke-direct {p0}, Landroid/support/v4/app/i;->Z()Landroid/support/v4/app/i$a;

    .line 2731
    iget-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    iget-object v0, v0, Landroid/support/v4/app/i$a;->r:Landroid/support/v4/app/i$c;

    if-ne p1, v0, :cond_0

    .line 2732
    return-void

    .line 2734
    :cond_0
    if-eqz p1, :cond_2

    if-nez v0, :cond_1

    goto :goto_0

    .line 2735
    :cond_1
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Trying to set a replacement startPostponedEnterTransition on "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 2738
    :cond_2
    :goto_0
    iget-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    iget-boolean v1, v0, Landroid/support/v4/app/i$a;->q:Z

    if-eqz v1, :cond_3

    .line 2739
    iput-object p1, v0, Landroid/support/v4/app/i$a;->r:Landroid/support/v4/app/i$c;

    .line 2741
    :cond_3
    if-eqz p1, :cond_4

    .line 2742
    invoke-interface {p1}, Landroid/support/v4/app/i$c;->a()V

    .line 2744
    :cond_4
    return-void
.end method

.method public a(Landroid/support/v4/app/i;)V
    .locals 0
    .param p1, "childFragment"    # Landroid/support/v4/app/i;

    .line 1410
    return-void
.end method

.method public a(Landroid/view/Menu;)V
    .locals 0
    .param p1, "menu"    # Landroid/view/Menu;

    .line 1844
    return-void
.end method

.method public a(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 0
    .param p1, "menu"    # Landroid/view/Menu;
    .param p2, "inflater"    # Landroid/view/MenuInflater;

    .line 1785
    return-void
.end method

.method a(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .line 2812
    invoke-direct {p0}, Landroid/support/v4/app/i;->Z()Landroid/support/v4/app/i$a;

    move-result-object v0

    iput-object p1, v0, Landroid/support/v4/app/i$a;->a:Landroid/view/View;

    .line 2813
    return-void
.end method

.method public a(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;
    .param p2, "savedInstanceState"    # Landroid/os/Bundle;

    .line 1567
    return-void
.end method

.method public a(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    .locals 3
    .param p1, "prefix"    # Ljava/lang/String;
    .param p2, "fd"    # Ljava/io/FileDescriptor;
    .param p3, "writer"    # Ljava/io/PrintWriter;
    .param p4, "args"    # [Ljava/lang/String;

    .line 2294
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mFragmentId=#"

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 2295
    iget v0, p0, Landroid/support/v4/app/i;->z:I

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 2296
    const-string v0, " mContainerId=#"

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 2297
    iget v0, p0, Landroid/support/v4/app/i;->A:I

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 2298
    const-string v0, " mTag="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-object v0, p0, Landroid/support/v4/app/i;->B:Ljava/lang/String;

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    .line 2299
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mState="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v0, p0, Landroid/support/v4/app/i;->c:I

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(I)V

    .line 2300
    const-string v0, " mIndex="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v0, p0, Landroid/support/v4/app/i;->g:I

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(I)V

    .line 2301
    const-string v0, " mWho="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-object v0, p0, Landroid/support/v4/app/i;->h:Ljava/lang/String;

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 2302
    const-string v0, " mBackStackNesting="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v0, p0, Landroid/support/v4/app/i;->s:I

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(I)V

    .line 2303
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mAdded="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean v0, p0, Landroid/support/v4/app/i;->m:Z

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Z)V

    .line 2304
    const-string v0, " mRemoving="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean v0, p0, Landroid/support/v4/app/i;->n:Z

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Z)V

    .line 2305
    const-string v0, " mFromLayout="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean v0, p0, Landroid/support/v4/app/i;->o:Z

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Z)V

    .line 2306
    const-string v0, " mInLayout="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean v0, p0, Landroid/support/v4/app/i;->p:Z

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(Z)V

    .line 2307
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mHidden="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean v0, p0, Landroid/support/v4/app/i;->C:Z

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Z)V

    .line 2308
    const-string v0, " mDetached="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean v0, p0, Landroid/support/v4/app/i;->D:Z

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Z)V

    .line 2309
    const-string v0, " mMenuVisible="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean v0, p0, Landroid/support/v4/app/i;->H:Z

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Z)V

    .line 2310
    const-string v0, " mHasMenu="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean v0, p0, Landroid/support/v4/app/i;->G:Z

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(Z)V

    .line 2311
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mRetainInstance="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean v0, p0, Landroid/support/v4/app/i;->E:Z

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Z)V

    .line 2312
    const-string v0, " mRetaining="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean v0, p0, Landroid/support/v4/app/i;->F:Z

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Z)V

    .line 2313
    const-string v0, " mUserVisibleHint="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-boolean v0, p0, Landroid/support/v4/app/i;->N:Z

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(Z)V

    .line 2314
    iget-object v0, p0, Landroid/support/v4/app/i;->t:Landroid/support/v4/app/v;

    if-eqz v0, :cond_0

    .line 2315
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mFragmentManager="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 2316
    iget-object v0, p0, Landroid/support/v4/app/i;->t:Landroid/support/v4/app/v;

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/Object;)V

    .line 2318
    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/i;->u:Landroid/support/v4/app/n;

    if-eqz v0, :cond_1

    .line 2319
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mHost="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 2320
    iget-object v0, p0, Landroid/support/v4/app/i;->u:Landroid/support/v4/app/n;

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/Object;)V

    .line 2322
    :cond_1
    iget-object v0, p0, Landroid/support/v4/app/i;->y:Landroid/support/v4/app/i;

    if-eqz v0, :cond_2

    .line 2323
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mParentFragment="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 2324
    iget-object v0, p0, Landroid/support/v4/app/i;->y:Landroid/support/v4/app/i;

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/Object;)V

    .line 2326
    :cond_2
    iget-object v0, p0, Landroid/support/v4/app/i;->i:Landroid/os/Bundle;

    if-eqz v0, :cond_3

    .line 2327
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mArguments="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-object v0, p0, Landroid/support/v4/app/i;->i:Landroid/os/Bundle;

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/Object;)V

    .line 2329
    :cond_3
    iget-object v0, p0, Landroid/support/v4/app/i;->d:Landroid/os/Bundle;

    if-eqz v0, :cond_4

    .line 2330
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mSavedFragmentState="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 2331
    iget-object v0, p0, Landroid/support/v4/app/i;->d:Landroid/os/Bundle;

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/Object;)V

    .line 2333
    :cond_4
    iget-object v0, p0, Landroid/support/v4/app/i;->e:Landroid/util/SparseArray;

    if-eqz v0, :cond_5

    .line 2334
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mSavedViewState="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 2335
    iget-object v0, p0, Landroid/support/v4/app/i;->e:Landroid/util/SparseArray;

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/Object;)V

    .line 2337
    :cond_5
    iget-object v0, p0, Landroid/support/v4/app/i;->j:Landroid/support/v4/app/i;

    if-eqz v0, :cond_6

    .line 2338
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mTarget="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-object v0, p0, Landroid/support/v4/app/i;->j:Landroid/support/v4/app/i;

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/Object;)V

    .line 2339
    const-string v0, " mTargetRequestCode="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 2340
    iget v0, p0, Landroid/support/v4/app/i;->l:I

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(I)V

    .line 2342
    :cond_6
    invoke-virtual {p0}, Landroid/support/v4/app/i;->p()I

    move-result v0

    if-eqz v0, :cond_7

    .line 2343
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mNextAnim="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    invoke-virtual {p0}, Landroid/support/v4/app/i;->p()I

    move-result v0

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(I)V

    .line 2345
    :cond_7
    iget-object v0, p0, Landroid/support/v4/app/i;->J:Landroid/view/ViewGroup;

    if-eqz v0, :cond_8

    .line 2346
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mContainer="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-object v0, p0, Landroid/support/v4/app/i;->J:Landroid/view/ViewGroup;

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/Object;)V

    .line 2348
    :cond_8
    iget-object v0, p0, Landroid/support/v4/app/i;->K:Landroid/view/View;

    if-eqz v0, :cond_9

    .line 2349
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mView="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-object v0, p0, Landroid/support/v4/app/i;->K:Landroid/view/View;

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/Object;)V

    .line 2351
    :cond_9
    iget-object v0, p0, Landroid/support/v4/app/i;->L:Landroid/view/View;

    if-eqz v0, :cond_a

    .line 2352
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mInnerView="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-object v0, p0, Landroid/support/v4/app/i;->K:Landroid/view/View;

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/Object;)V

    .line 2354
    :cond_a
    invoke-virtual {p0}, Landroid/support/v4/app/i;->g()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_b

    .line 2355
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 2356
    const-string v0, "mAnimatingAway="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 2357
    invoke-virtual {p0}, Landroid/support/v4/app/i;->g()Landroid/view/View;

    move-result-object v0

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/Object;)V

    .line 2358
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 2359
    const-string v0, "mStateAfterAnimating="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    .line 2360
    invoke-virtual {p0}, Landroid/support/v4/app/i;->x()I

    move-result v0

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(I)V

    .line 2362
    :cond_b
    invoke-virtual {p0}, Landroid/support/v4/app/i;->j()Landroid/content/Context;

    move-result-object v0

    if-eqz v0, :cond_c

    .line 2363
    invoke-static {p0}, Landroid/support/v4/app/Q;->a(Landroid/arch/lifecycle/f;)Landroid/support/v4/app/Q;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3, p4}, Landroid/support/v4/app/Q;->a(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V

    .line 2365
    :cond_c
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v0, :cond_d

    .line 2366
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Child "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v1, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    .line 2367
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v2, "  "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p2, p3, p4}, Landroid/support/v4/app/v;->a(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V

    .line 2369
    :cond_d
    return-void
.end method

.method public a(Z)V
    .locals 0
    .param p1, "hidden"    # Z

    .line 961
    return-void
.end method

.method public a(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .line 1911
    const/4 v0, 0x0

    return v0
.end method

.method public b(IZI)Landroid/animation/Animator;
    .locals 1
    .param p1, "transit"    # I
    .param p2, "enter"    # Z
    .param p3, "nextAnim"    # I

    .line 1474
    const/4 v0, 0x0

    return-object v0
.end method

.method public b()Landroid/arch/lifecycle/s;
    .locals 2

    .line 327
    invoke-virtual {p0}, Landroid/support/v4/app/i;->j()Landroid/content/Context;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 330
    iget-object v0, p0, Landroid/support/v4/app/i;->x:Landroid/arch/lifecycle/s;

    if-nez v0, :cond_0

    .line 331
    new-instance v0, Landroid/arch/lifecycle/s;

    invoke-direct {v0}, Landroid/arch/lifecycle/s;-><init>()V

    iput-object v0, p0, Landroid/support/v4/app/i;->x:Landroid/arch/lifecycle/s;

    .line 333
    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/i;->x:Landroid/arch/lifecycle/s;

    return-object v0

    .line 328
    :cond_1
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Can\'t access ViewModels from detached fragment"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method b(I)V
    .locals 1
    .param p1, "state"    # I

    .line 2834
    invoke-direct {p0}, Landroid/support/v4/app/i;->Z()Landroid/support/v4/app/i$a;

    move-result-object v0

    iput p1, v0, Landroid/support/v4/app/i$a;->c:I

    .line 2835
    return-void
.end method

.method public b(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 1595
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    .line 1596
    return-void
.end method

.method b(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)V
    .locals 2
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .line 2425
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v0, :cond_0

    .line 2426
    invoke-virtual {v0}, Landroid/support/v4/app/v;->q()V

    .line 2428
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/i;->r:Z

    .line 2429
    new-instance v0, Landroid/support/v4/app/h;

    invoke-direct {v0, p0}, Landroid/support/v4/app/h;-><init>(Landroid/support/v4/app/i;)V

    iput-object v0, p0, Landroid/support/v4/app/i;->W:Landroid/arch/lifecycle/f;

    .line 2438
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v4/app/i;->V:Landroid/arch/lifecycle/h;

    .line 2439
    invoke-virtual {p0, p1, p2, p3}, Landroid/support/v4/app/i;->a(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Landroid/support/v4/app/i;->K:Landroid/view/View;

    .line 2440
    iget-object v1, p0, Landroid/support/v4/app/i;->K:Landroid/view/View;

    if-eqz v1, :cond_1

    .line 2442
    iget-object v0, p0, Landroid/support/v4/app/i;->W:Landroid/arch/lifecycle/f;

    invoke-interface {v0}, Landroid/arch/lifecycle/f;->a()Landroid/arch/lifecycle/d;

    .line 2444
    iget-object v0, p0, Landroid/support/v4/app/i;->X:Landroid/arch/lifecycle/m;

    iget-object v1, p0, Landroid/support/v4/app/i;->W:Landroid/arch/lifecycle/f;

    invoke-virtual {v0, v1}, Landroid/arch/lifecycle/m;->a(Ljava/lang/Object;)V

    goto :goto_0

    .line 2446
    :cond_1
    iget-object v1, p0, Landroid/support/v4/app/i;->V:Landroid/arch/lifecycle/h;

    if-nez v1, :cond_2

    .line 2450
    iput-object v0, p0, Landroid/support/v4/app/i;->W:Landroid/arch/lifecycle/f;

    .line 2452
    :goto_0
    return-void

    .line 2447
    :cond_2
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Called getViewLifecycleOwner() but onCreateView() returned null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public b(Landroid/view/Menu;)V
    .locals 0
    .param p1, "menu"    # Landroid/view/Menu;

    .line 1802
    return-void
.end method

.method public b(Z)V
    .locals 0
    .param p1, "isInMultiWindowMode"    # Z

    .line 1665
    return-void
.end method

.method b(Landroid/view/Menu;Landroid/view/MenuInflater;)Z
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;
    .param p2, "inflater"    # Landroid/view/MenuInflater;

    .line 2557
    const/4 v0, 0x0

    .line 2558
    .local v0, "show":Z
    iget-boolean v1, p0, Landroid/support/v4/app/i;->C:Z

    if-nez v1, :cond_1

    .line 2559
    iget-boolean v1, p0, Landroid/support/v4/app/i;->G:Z

    if-eqz v1, :cond_0

    iget-boolean v1, p0, Landroid/support/v4/app/i;->H:Z

    if-eqz v1, :cond_0

    .line 2560
    const/4 v0, 0x1

    .line 2561
    invoke-virtual {p0, p1, p2}, Landroid/support/v4/app/i;->a(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 2563
    :cond_0
    iget-object v1, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v1, :cond_1

    .line 2564
    invoke-virtual {v1, p1, p2}, Landroid/support/v4/app/v;->a(Landroid/view/Menu;Landroid/view/MenuInflater;)Z

    move-result v1

    or-int/2addr v0, v1

    .line 2567
    :cond_1
    return v0
.end method

.method public b(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .line 1833
    const/4 v0, 0x0

    return v0
.end method

.method c()V
    .locals 3

    .line 2272
    iget-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    if-nez v0, :cond_0

    .line 2273
    const/4 v0, 0x0

    .local v0, "listener":Landroid/support/v4/app/i$c;
    goto :goto_0

    .line 2275
    .end local v0    # "listener":Landroid/support/v4/app/i$c;
    :cond_0
    const/4 v1, 0x0

    iput-boolean v1, v0, Landroid/support/v4/app/i$a;->q:Z

    .line 2276
    iget-object v1, v0, Landroid/support/v4/app/i$a;->r:Landroid/support/v4/app/i$c;

    .line 2277
    .local v1, "listener":Landroid/support/v4/app/i$c;
    const/4 v2, 0x0

    iput-object v2, v0, Landroid/support/v4/app/i$a;->r:Landroid/support/v4/app/i$c;

    move-object v0, v1

    .line 2279
    .end local v1    # "listener":Landroid/support/v4/app/i$c;
    .restart local v0    # "listener":Landroid/support/v4/app/i$c;
    :goto_0
    if-eqz v0, :cond_1

    .line 2280
    invoke-interface {v0}, Landroid/support/v4/app/i$c;->b()V

    .line 2282
    :cond_1
    return-void
.end method

.method public c(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 1496
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    .line 1497
    invoke-virtual {p0, p1}, Landroid/support/v4/app/i;->k(Landroid/os/Bundle;)V

    .line 1498
    iget-object v1, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v1, :cond_0

    .line 1499
    invoke-virtual {v1, v0}, Landroid/support/v4/app/v;->c(I)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1500
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    invoke-virtual {v0}, Landroid/support/v4/app/v;->e()V

    .line 1502
    :cond_0
    return-void
.end method

.method c(Landroid/view/Menu;)V
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .line 2615
    iget-boolean v0, p0, Landroid/support/v4/app/i;->C:Z

    if-nez v0, :cond_1

    .line 2616
    iget-boolean v0, p0, Landroid/support/v4/app/i;->G:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Landroid/support/v4/app/i;->H:Z

    if-eqz v0, :cond_0

    .line 2617
    invoke-virtual {p0, p1}, Landroid/support/v4/app/i;->a(Landroid/view/Menu;)V

    .line 2619
    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v0, :cond_1

    .line 2620
    invoke-virtual {v0, p1}, Landroid/support/v4/app/v;->a(Landroid/view/Menu;)V

    .line 2623
    :cond_1
    return-void
.end method

.method public c(Z)V
    .locals 0
    .param p1, "isInPictureInPictureMode"    # Z

    .line 1674
    return-void
.end method

.method c(Landroid/view/MenuItem;)Z
    .locals 2
    .param p1, "item"    # Landroid/view/MenuItem;

    .line 2601
    iget-boolean v0, p0, Landroid/support/v4/app/i;->C:Z

    if-nez v0, :cond_1

    .line 2602
    invoke-virtual {p0, p1}, Landroid/support/v4/app/i;->a(Landroid/view/MenuItem;)Z

    move-result v0

    const/4 v1, 0x1

    if-eqz v0, :cond_0

    .line 2603
    return v1

    .line 2605
    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v0, :cond_1

    .line 2606
    invoke-virtual {v0, p1}, Landroid/support/v4/app/v;->a(Landroid/view/MenuItem;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2607
    return v1

    .line 2611
    :cond_1
    const/4 v0, 0x0

    return v0
.end method

.method public final d()Landroid/support/v4/app/k;
    .locals 1

    .line 710
    iget-object v0, p0, Landroid/support/v4/app/i;->u:Landroid/support/v4/app/n;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    goto :goto_0

    :cond_0
    invoke-virtual {v0}, Landroid/support/v4/app/n;->b()Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/k;

    :goto_0
    return-object v0
.end method

.method public d(Landroid/os/Bundle;)Landroid/view/LayoutInflater;
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 1277
    invoke-virtual {p0, p1}, Landroid/support/v4/app/i;->a(Landroid/os/Bundle;)Landroid/view/LayoutInflater;

    move-result-object v0

    return-object v0
.end method

.method d(Z)V
    .locals 1
    .param p1, "isInMultiWindowMode"    # Z

    .line 2520
    invoke-virtual {p0, p1}, Landroid/support/v4/app/i;->b(Z)V

    .line 2521
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v0, :cond_0

    .line 2522
    invoke-virtual {v0, p1}, Landroid/support/v4/app/v;->a(Z)V

    .line 2524
    :cond_0
    return-void
.end method

.method d(Landroid/view/Menu;)Z
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;

    .line 2571
    const/4 v0, 0x0

    .line 2572
    .local v0, "show":Z
    iget-boolean v1, p0, Landroid/support/v4/app/i;->C:Z

    if-nez v1, :cond_1

    .line 2573
    iget-boolean v1, p0, Landroid/support/v4/app/i;->G:Z

    if-eqz v1, :cond_0

    iget-boolean v1, p0, Landroid/support/v4/app/i;->H:Z

    if-eqz v1, :cond_0

    .line 2574
    const/4 v0, 0x1

    .line 2575
    invoke-virtual {p0, p1}, Landroid/support/v4/app/i;->b(Landroid/view/Menu;)V

    .line 2577
    :cond_0
    iget-object v1, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v1, :cond_1

    .line 2578
    invoke-virtual {v1, p1}, Landroid/support/v4/app/v;->b(Landroid/view/Menu;)Z

    move-result v1

    or-int/2addr v0, v1

    .line 2581
    :cond_1
    return v0
.end method

.method d(Landroid/view/MenuItem;)Z
    .locals 2
    .param p1, "item"    # Landroid/view/MenuItem;

    .line 2585
    iget-boolean v0, p0, Landroid/support/v4/app/i;->C:Z

    if-nez v0, :cond_1

    .line 2586
    iget-boolean v0, p0, Landroid/support/v4/app/i;->G:Z

    const/4 v1, 0x1

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Landroid/support/v4/app/i;->H:Z

    if-eqz v0, :cond_0

    .line 2587
    invoke-virtual {p0, p1}, Landroid/support/v4/app/i;->b(Landroid/view/MenuItem;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2588
    return v1

    .line 2591
    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v0, :cond_1

    .line 2592
    invoke-virtual {v0, p1}, Landroid/support/v4/app/v;->b(Landroid/view/MenuItem;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2593
    return v1

    .line 2597
    :cond_1
    const/4 v0, 0x0

    return v0
.end method

.method public e(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "outState"    # Landroid/os/Bundle;

    .line 1655
    return-void
.end method

.method e(Z)V
    .locals 1
    .param p1, "isInPictureInPictureMode"    # Z

    .line 2527
    invoke-virtual {p0, p1}, Landroid/support/v4/app/i;->c(Z)V

    .line 2528
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v0, :cond_0

    .line 2529
    invoke-virtual {v0, p1}, Landroid/support/v4/app/v;->b(Z)V

    .line 2531
    :cond_0
    return-void
.end method

.method public e()Z
    .locals 1

    .line 2178
    iget-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    if-eqz v0, :cond_1

    iget-object v0, v0, Landroid/support/v4/app/i$a;->n:Ljava/lang/Boolean;

    if-nez v0, :cond_0

    goto :goto_0

    .line 2179
    :cond_0
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    goto :goto_1

    .line 2178
    :cond_1
    :goto_0
    const/4 v0, 0x1

    .line 2179
    :goto_1
    return v0
.end method

.method public final equals(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "o"    # Ljava/lang/Object;

    .line 525
    invoke-super {p0, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public f(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 1611
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    .line 1612
    return-void
.end method

.method f(Z)V
    .locals 1
    .param p1, "replaced"    # Z

    .line 2852
    invoke-direct {p0}, Landroid/support/v4/app/i;->Z()Landroid/support/v4/app/i$a;

    move-result-object v0

    iput-boolean p1, v0, Landroid/support/v4/app/i$a;->s:Z

    .line 2853
    return-void
.end method

.method public f()Z
    .locals 1

    .line 2203
    iget-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    if-eqz v0, :cond_1

    iget-object v0, v0, Landroid/support/v4/app/i$a;->m:Ljava/lang/Boolean;

    if-nez v0, :cond_0

    goto :goto_0

    .line 2204
    :cond_0
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    goto :goto_1

    .line 2203
    :cond_1
    :goto_0
    const/4 v0, 0x1

    .line 2204
    :goto_1
    return v0
.end method

.method g()Landroid/view/View;
    .locals 1

    .line 2805
    iget-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    if-nez v0, :cond_0

    .line 2806
    const/4 v0, 0x0

    return-object v0

    .line 2808
    :cond_0
    iget-object v0, v0, Landroid/support/v4/app/i$a;->a:Landroid/view/View;

    return-object v0
.end method

.method g(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 2455
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v0, :cond_0

    .line 2456
    invoke-virtual {v0}, Landroid/support/v4/app/v;->q()V

    .line 2458
    :cond_0
    const/4 v0, 0x2

    iput v0, p0, Landroid/support/v4/app/i;->c:I

    .line 2459
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    .line 2460
    invoke-virtual {p0, p1}, Landroid/support/v4/app/i;->b(Landroid/os/Bundle;)V

    .line 2461
    iget-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    if-eqz v0, :cond_2

    .line 2465
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v0, :cond_1

    .line 2466
    invoke-virtual {v0}, Landroid/support/v4/app/v;->d()V

    .line 2468
    :cond_1
    return-void

    .line 2462
    :cond_2
    new-instance v0, Landroid/support/v4/app/W;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Fragment "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v2, " did not call through to super.onActivityCreated()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/support/v4/app/W;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method h()Landroid/animation/Animator;
    .locals 1

    .line 2820
    iget-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    if-nez v0, :cond_0

    .line 2821
    const/4 v0, 0x0

    return-object v0

    .line 2823
    :cond_0
    iget-object v0, v0, Landroid/support/v4/app/i$a;->b:Landroid/animation/Animator;

    return-object v0
.end method

.method h(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 2409
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v0, :cond_0

    .line 2410
    invoke-virtual {v0}, Landroid/support/v4/app/v;->q()V

    .line 2412
    :cond_0
    const/4 v0, 0x1

    iput v0, p0, Landroid/support/v4/app/i;->c:I

    .line 2413
    const/4 v1, 0x0

    iput-boolean v1, p0, Landroid/support/v4/app/i;->I:Z

    .line 2414
    invoke-virtual {p0, p1}, Landroid/support/v4/app/i;->c(Landroid/os/Bundle;)V

    .line 2415
    iput-boolean v0, p0, Landroid/support/v4/app/i;->T:Z

    .line 2416
    iget-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    if-eqz v0, :cond_1

    .line 2420
    iget-object v0, p0, Landroid/support/v4/app/i;->U:Landroid/arch/lifecycle/h;

    sget-object v1, Landroid/arch/lifecycle/d$a;->ON_CREATE:Landroid/arch/lifecycle/d$a;

    invoke-virtual {v0, v1}, Landroid/arch/lifecycle/h;->b(Landroid/arch/lifecycle/d$a;)V

    .line 2421
    return-void

    .line 2417
    :cond_1
    new-instance v0, Landroid/support/v4/app/W;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Fragment "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v2, " did not call through to super.onCreate()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/support/v4/app/W;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public final hashCode()I
    .locals 1

    .line 532
    invoke-super {p0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    return v0
.end method

.method public final i()Landroid/support/v4/app/o;
    .locals 2

    .line 844
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-nez v0, :cond_3

    .line 845
    invoke-virtual {p0}, Landroid/support/v4/app/i;->A()V

    .line 846
    iget v0, p0, Landroid/support/v4/app/i;->c:I

    const/4 v1, 0x4

    if-lt v0, v1, :cond_0

    .line 847
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    invoke-virtual {v0}, Landroid/support/v4/app/v;->j()V

    goto :goto_0

    .line 848
    :cond_0
    const/4 v1, 0x3

    if-lt v0, v1, :cond_1

    .line 849
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    invoke-virtual {v0}, Landroid/support/v4/app/v;->k()V

    goto :goto_0

    .line 850
    :cond_1
    const/4 v1, 0x2

    if-lt v0, v1, :cond_2

    .line 851
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    invoke-virtual {v0}, Landroid/support/v4/app/v;->d()V

    goto :goto_0

    .line 852
    :cond_2
    const/4 v1, 0x1

    if-lt v0, v1, :cond_3

    .line 853
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    invoke-virtual {v0}, Landroid/support/v4/app/v;->e()V

    .line 856
    :cond_3
    :goto_0
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    return-object v0
.end method

.method i(Landroid/os/Bundle;)Landroid/view/LayoutInflater;
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 1308
    invoke-virtual {p0, p1}, Landroid/support/v4/app/i;->d(Landroid/os/Bundle;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 1309
    .local v0, "layoutInflater":Landroid/view/LayoutInflater;
    iput-object v0, p0, Landroid/support/v4/app/i;->S:Landroid/view/LayoutInflater;

    .line 1310
    iget-object v1, p0, Landroid/support/v4/app/i;->S:Landroid/view/LayoutInflater;

    return-object v1
.end method

.method public j()Landroid/content/Context;
    .locals 1

    .line 683
    iget-object v0, p0, Landroid/support/v4/app/i;->u:Landroid/support/v4/app/n;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    goto :goto_0

    :cond_0
    invoke-virtual {v0}, Landroid/support/v4/app/n;->c()Landroid/content/Context;

    move-result-object v0

    :goto_0
    return-object v0
.end method

.method j(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .line 2626
    invoke-virtual {p0, p1}, Landroid/support/v4/app/i;->e(Landroid/os/Bundle;)V

    .line 2627
    iget-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-eqz v0, :cond_0

    .line 2628
    invoke-virtual {v0}, Landroid/support/v4/app/v;->t()Landroid/os/Parcelable;

    move-result-object v0

    .line 2629
    .local v0, "p":Landroid/os/Parcelable;
    if-eqz v0, :cond_0

    .line 2630
    const-string v1, "android:support:fragments"

    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 2633
    .end local v0    # "p":Landroid/os/Parcelable;
    :cond_0
    return-void
.end method

.method public k()Ljava/lang/Object;
    .locals 1

    .line 1961
    iget-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    if-nez v0, :cond_0

    .line 1962
    const/4 v0, 0x0

    return-object v0

    .line 1964
    :cond_0
    iget-object v0, v0, Landroid/support/v4/app/i$a;->g:Ljava/lang/Object;

    return-object v0
.end method

.method k(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 1517
    if-eqz p1, :cond_1

    .line 1518
    const-string v0, "android:support:fragments"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    .line 1520
    .local v0, "p":Landroid/os/Parcelable;
    if-eqz v0, :cond_1

    .line 1521
    iget-object v1, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    if-nez v1, :cond_0

    .line 1522
    invoke-virtual {p0}, Landroid/support/v4/app/i;->A()V

    .line 1524
    :cond_0
    iget-object v1, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    iget-object v2, p0, Landroid/support/v4/app/i;->w:Landroid/support/v4/app/w;

    invoke-virtual {v1, v0, v2}, Landroid/support/v4/app/v;->a(Landroid/os/Parcelable;Landroid/support/v4/app/w;)V

    .line 1525
    const/4 v1, 0x0

    iput-object v1, p0, Landroid/support/v4/app/i;->w:Landroid/support/v4/app/w;

    .line 1526
    iget-object v1, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    invoke-virtual {v1}, Landroid/support/v4/app/v;->e()V

    .line 1529
    .end local v0    # "p":Landroid/os/Parcelable;
    :cond_1
    return-void
.end method

.method l()Landroid/support/v4/app/V;
    .locals 1

    .line 2791
    iget-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    if-nez v0, :cond_0

    .line 2792
    const/4 v0, 0x0

    return-object v0

    .line 2794
    :cond_0
    iget-object v0, v0, Landroid/support/v4/app/i$a;->o:Landroid/support/v4/app/V;

    return-object v0
.end method

.method final l(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .line 493
    iget-object v0, p0, Landroid/support/v4/app/i;->e:Landroid/util/SparseArray;

    if-eqz v0, :cond_0

    .line 494
    iget-object v1, p0, Landroid/support/v4/app/i;->L:Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/View;->restoreHierarchyState(Landroid/util/SparseArray;)V

    .line 495
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v4/app/i;->e:Landroid/util/SparseArray;

    .line 497
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    .line 498
    invoke-virtual {p0, p1}, Landroid/support/v4/app/i;->f(Landroid/os/Bundle;)V

    .line 499
    iget-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    if-eqz v0, :cond_2

    .line 503
    iget-object v0, p0, Landroid/support/v4/app/i;->K:Landroid/view/View;

    if-eqz v0, :cond_1

    .line 504
    iget-object v0, p0, Landroid/support/v4/app/i;->V:Landroid/arch/lifecycle/h;

    sget-object v1, Landroid/arch/lifecycle/d$a;->ON_CREATE:Landroid/arch/lifecycle/d$a;

    invoke-virtual {v0, v1}, Landroid/arch/lifecycle/h;->b(Landroid/arch/lifecycle/d$a;)V

    .line 506
    :cond_1
    return-void

    .line 500
    :cond_2
    new-instance v0, Landroid/support/v4/app/W;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Fragment "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    const-string v2, " did not call through to super.onViewStateRestored()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/support/v4/app/W;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public m()Ljava/lang/Object;
    .locals 1

    .line 2040
    iget-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    if-nez v0, :cond_0

    .line 2041
    const/4 v0, 0x0

    return-object v0

    .line 2043
    :cond_0
    iget-object v0, v0, Landroid/support/v4/app/i$a;->i:Ljava/lang/Object;

    return-object v0
.end method

.method public m(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "args"    # Landroid/os/Bundle;

    .line 580
    iget v0, p0, Landroid/support/v4/app/i;->g:I

    if-ltz v0, :cond_1

    invoke-virtual {p0}, Landroid/support/v4/app/i;->E()Z

    move-result v0

    if-nez v0, :cond_0

    goto :goto_0

    .line 581
    :cond_0
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Fragment already active and state has been saved"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 583
    :cond_1
    :goto_0
    iput-object p1, p0, Landroid/support/v4/app/i;->i:Landroid/os/Bundle;

    .line 584
    return-void
.end method

.method n()Landroid/support/v4/app/V;
    .locals 1

    .line 2798
    iget-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    if-nez v0, :cond_0

    .line 2799
    const/4 v0, 0x0

    return-object v0

    .line 2801
    :cond_0
    iget-object v0, v0, Landroid/support/v4/app/i$a;->p:Landroid/support/v4/app/V;

    return-object v0
.end method

.method public final o()Landroid/support/v4/app/o;
    .locals 1

    .line 812
    iget-object v0, p0, Landroid/support/v4/app/i;->t:Landroid/support/v4/app/v;

    return-object v0
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 1
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .line 1679
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    .line 1680
    return-void
.end method

.method public onCreateContextMenu(Landroid/view/ContextMenu;Landroid/view/View;Landroid/view/ContextMenu$ContextMenuInfo;)V
    .locals 1
    .param p1, "menu"    # Landroid/view/ContextMenu;
    .param p2, "v"    # Landroid/view/View;
    .param p3, "menuInfo"    # Landroid/view/ContextMenu$ContextMenuInfo;

    .line 1865
    invoke-virtual {p0}, Landroid/support/v4/app/i;->d()Landroid/support/v4/app/k;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Landroid/app/Activity;->onCreateContextMenu(Landroid/view/ContextMenu;Landroid/view/View;Landroid/view/ContextMenu$ContextMenuInfo;)V

    .line 1866
    return-void
.end method

.method public onLowMemory()V
    .locals 1

    .line 1705
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v4/app/i;->I:Z

    .line 1706
    return-void
.end method

.method p()I
    .locals 1

    .line 2754
    iget-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    if-nez v0, :cond_0

    .line 2755
    const/4 v0, 0x0

    return v0

    .line 2757
    :cond_0
    iget v0, v0, Landroid/support/v4/app/i$a;->d:I

    return v0
.end method

.method q()I
    .locals 1

    .line 2768
    iget-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    if-nez v0, :cond_0

    .line 2769
    const/4 v0, 0x0

    return v0

    .line 2771
    :cond_0
    iget v0, v0, Landroid/support/v4/app/i$a;->e:I

    return v0
.end method

.method r()I
    .locals 1

    .line 2784
    iget-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    if-nez v0, :cond_0

    .line 2785
    const/4 v0, 0x0

    return v0

    .line 2787
    :cond_0
    iget v0, v0, Landroid/support/v4/app/i$a;->f:I

    return v0
.end method

.method public s()Ljava/lang/Object;
    .locals 2

    .line 2078
    iget-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    if-nez v0, :cond_0

    .line 2079
    const/4 v0, 0x0

    return-object v0

    .line 2081
    :cond_0
    iget-object v0, v0, Landroid/support/v4/app/i$a;->j:Ljava/lang/Object;

    sget-object v1, Landroid/support/v4/app/i;->b:Ljava/lang/Object;

    if-ne v0, v1, :cond_1

    invoke-virtual {p0}, Landroid/support/v4/app/i;->m()Ljava/lang/Object;

    move-result-object v0

    :cond_1
    return-object v0
.end method

.method public final t()Landroid/content/res/Resources;
    .locals 1

    .line 760
    invoke-virtual {p0}, Landroid/support/v4/app/i;->X()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .line 537
    new-instance v0, Ljava/lang/StringBuilder;

    const/16 v1, 0x80

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 538
    .local v0, "sb":Ljava/lang/StringBuilder;
    invoke-static {p0, v0}, La/b/c/f/f;->a(Ljava/lang/Object;Ljava/lang/StringBuilder;)V

    .line 539
    iget v1, p0, Landroid/support/v4/app/i;->g:I

    if-ltz v1, :cond_0

    .line 540
    const-string v1, " #"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 541
    iget v1, p0, Landroid/support/v4/app/i;->g:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 543
    :cond_0
    iget v1, p0, Landroid/support/v4/app/i;->z:I

    if-eqz v1, :cond_1

    .line 544
    const-string v1, " id=0x"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 545
    iget v1, p0, Landroid/support/v4/app/i;->z:I

    invoke-static {v1}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 547
    :cond_1
    iget-object v1, p0, Landroid/support/v4/app/i;->B:Ljava/lang/String;

    if-eqz v1, :cond_2

    .line 548
    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 549
    iget-object v1, p0, Landroid/support/v4/app/i;->B:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 551
    :cond_2
    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 552
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public u()Ljava/lang/Object;
    .locals 2

    .line 2000
    iget-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    if-nez v0, :cond_0

    .line 2001
    const/4 v0, 0x0

    return-object v0

    .line 2003
    :cond_0
    iget-object v0, v0, Landroid/support/v4/app/i$a;->h:Ljava/lang/Object;

    sget-object v1, Landroid/support/v4/app/i;->b:Ljava/lang/Object;

    if-ne v0, v1, :cond_1

    invoke-virtual {p0}, Landroid/support/v4/app/i;->k()Ljava/lang/Object;

    move-result-object v0

    :cond_1
    return-object v0
.end method

.method public v()Ljava/lang/Object;
    .locals 1

    .line 2111
    iget-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    if-nez v0, :cond_0

    .line 2112
    const/4 v0, 0x0

    return-object v0

    .line 2114
    :cond_0
    iget-object v0, v0, Landroid/support/v4/app/i$a;->k:Ljava/lang/Object;

    return-object v0
.end method

.method public w()Ljava/lang/Object;
    .locals 2

    .line 2149
    iget-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    if-nez v0, :cond_0

    .line 2150
    const/4 v0, 0x0

    return-object v0

    .line 2152
    :cond_0
    iget-object v0, v0, Landroid/support/v4/app/i$a;->l:Ljava/lang/Object;

    sget-object v1, Landroid/support/v4/app/i;->b:Ljava/lang/Object;

    if-ne v0, v1, :cond_1

    .line 2153
    invoke-virtual {p0}, Landroid/support/v4/app/i;->v()Ljava/lang/Object;

    move-result-object v0

    goto :goto_0

    :cond_1
    nop

    :goto_0
    return-object v0
.end method

.method x()I
    .locals 1

    .line 2827
    iget-object v0, p0, Landroid/support/v4/app/i;->O:Landroid/support/v4/app/i$a;

    if-nez v0, :cond_0

    .line 2828
    const/4 v0, 0x0

    return v0

    .line 2830
    :cond_0
    iget v0, v0, Landroid/support/v4/app/i$a;->c:I

    return v0
.end method

.method public y()Landroid/view/View;
    .locals 1

    .line 1577
    iget-object v0, p0, Landroid/support/v4/app/i;->K:Landroid/view/View;

    return-object v0
.end method

.method z()V
    .locals 2

    .line 1743
    const/4 v0, -0x1

    iput v0, p0, Landroid/support/v4/app/i;->g:I

    .line 1744
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v4/app/i;->h:Ljava/lang/String;

    .line 1745
    const/4 v1, 0x0

    iput-boolean v1, p0, Landroid/support/v4/app/i;->m:Z

    .line 1746
    iput-boolean v1, p0, Landroid/support/v4/app/i;->n:Z

    .line 1747
    iput-boolean v1, p0, Landroid/support/v4/app/i;->o:Z

    .line 1748
    iput-boolean v1, p0, Landroid/support/v4/app/i;->p:Z

    .line 1749
    iput-boolean v1, p0, Landroid/support/v4/app/i;->q:Z

    .line 1750
    iput v1, p0, Landroid/support/v4/app/i;->s:I

    .line 1751
    iput-object v0, p0, Landroid/support/v4/app/i;->t:Landroid/support/v4/app/v;

    .line 1752
    iput-object v0, p0, Landroid/support/v4/app/i;->v:Landroid/support/v4/app/v;

    .line 1753
    iput-object v0, p0, Landroid/support/v4/app/i;->u:Landroid/support/v4/app/n;

    .line 1754
    iput v1, p0, Landroid/support/v4/app/i;->z:I

    .line 1755
    iput v1, p0, Landroid/support/v4/app/i;->A:I

    .line 1756
    iput-object v0, p0, Landroid/support/v4/app/i;->B:Ljava/lang/String;

    .line 1757
    iput-boolean v1, p0, Landroid/support/v4/app/i;->C:Z

    .line 1758
    iput-boolean v1, p0, Landroid/support/v4/app/i;->D:Z

    .line 1759
    iput-boolean v1, p0, Landroid/support/v4/app/i;->F:Z

    .line 1760
    return-void
.end method
