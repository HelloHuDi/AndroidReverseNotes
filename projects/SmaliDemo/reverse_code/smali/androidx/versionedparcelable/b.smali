.class public abstract Landroidx/versionedparcelable/b;
.super Ljava/lang/Object;
.source ""


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 55
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1492
    return-void
.end method

.method protected static a(Ljava/lang/String;Landroidx/versionedparcelable/b;)Landroidx/versionedparcelable/d;
    .locals 6
    .param p0, "parcelCls"    # Ljava/lang/String;
    .param p1, "versionedParcel"    # Landroidx/versionedparcelable/b;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Landroidx/versionedparcelable/d;",
            ">(",
            "Ljava/lang/String;",
            "Landroidx/versionedparcelable/b;",
            ")TT;"
        }
    .end annotation

    .line 1438
    :try_start_0
    const-class v0, Landroidx/versionedparcelable/b;

    invoke-virtual {v0}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    const/4 v1, 0x1

    invoke-static {p0, v1, v0}, Ljava/lang/Class;->forName(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;

    move-result-object v0

    .line 1439
    .local v0, "cls":Ljava/lang/Class;
    const-string v2, "read"

    new-array v3, v1, [Ljava/lang/Class;

    const-class v4, Landroidx/versionedparcelable/b;

    const/4 v5, 0x0

    aput-object v4, v3, v5

    invoke-virtual {v0, v2, v3}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v2

    const/4 v3, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    aput-object p1, v1, v5

    .line 1440
    invoke-virtual {v2, v3, v1}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroidx/versionedparcelable/d;
    :try_end_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    return-object v1

    .line 1450
    .end local v0    # "cls":Ljava/lang/Class;
    :catch_0
    move-exception v0

    .line 1451
    .local v0, "e":Ljava/lang/ClassNotFoundException;
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "VersionedParcel encountered ClassNotFoundException"

    invoke-direct {v1, v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    .line 1448
    .end local v0    # "e":Ljava/lang/ClassNotFoundException;
    :catch_1
    move-exception v0

    .line 1449
    .local v0, "e":Ljava/lang/NoSuchMethodException;
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "VersionedParcel encountered NoSuchMethodException"

    invoke-direct {v1, v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    .line 1443
    .end local v0    # "e":Ljava/lang/NoSuchMethodException;
    :catch_2
    move-exception v0

    .line 1444
    .local v0, "e":Ljava/lang/reflect/InvocationTargetException;
    invoke-virtual {v0}, Ljava/lang/reflect/InvocationTargetException;->getCause()Ljava/lang/Throwable;

    move-result-object v1

    instance-of v1, v1, Ljava/lang/RuntimeException;

    if-eqz v1, :cond_0

    .line 1445
    invoke-virtual {v0}, Ljava/lang/reflect/InvocationTargetException;->getCause()Ljava/lang/Throwable;

    move-result-object v1

    check-cast v1, Ljava/lang/RuntimeException;

    throw v1

    .line 1447
    :cond_0
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "VersionedParcel encountered InvocationTargetException"

    invoke-direct {v1, v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    .line 1441
    .end local v0    # "e":Ljava/lang/reflect/InvocationTargetException;
    :catch_3
    move-exception v0

    .line 1442
    .local v0, "e":Ljava/lang/IllegalAccessException;
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "VersionedParcel encountered IllegalAccessException"

    invoke-direct {v1, v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method private static a(Ljava/lang/Class;)Ljava/lang/Class;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class<",
            "+",
            "Landroidx/versionedparcelable/d;",
            ">;)",
            "Ljava/lang/Class;"
        }
    .end annotation

    .line 1485
    .local p0, "cls":Ljava/lang/Class;, "Ljava/lang/Class<+Landroidx/versionedparcelable/VersionedParcelable;>;"
    invoke-virtual {p0}, Ljava/lang/Class;->getPackage()Ljava/lang/Package;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Package;->getName()Ljava/lang/String;

    move-result-object v0

    .line 1486
    .local v0, "pkg":Ljava/lang/String;
    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object v0, v1, v2

    invoke-virtual {p0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x1

    aput-object v3, v1, v4

    const-string v3, "%s.%sParcelizer"

    invoke-static {v3, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 1487
    .local v1, "c":Ljava/lang/String;
    invoke-virtual {p0}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v3

    invoke-static {v1, v2, v3}, Ljava/lang/Class;->forName(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;

    move-result-object v2

    return-object v2
.end method

.method protected static a(Landroidx/versionedparcelable/d;Landroidx/versionedparcelable/b;)V
    .locals 7
    .param p1, "versionedParcel"    # Landroidx/versionedparcelable/b;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Landroidx/versionedparcelable/d;",
            ">(TT;",
            "Landroidx/versionedparcelable/b;",
            ")V"
        }
    .end annotation

    .line 1460
    .local p0, "val":Landroidx/versionedparcelable/d;, "TT;"
    :try_start_0
    invoke-static {p0}, Landroidx/versionedparcelable/b;->b(Landroidx/versionedparcelable/d;)Ljava/lang/Class;

    move-result-object v0

    .line 1461
    .local v0, "cls":Ljava/lang/Class;
    const-string v1, "write"

    const/4 v2, 0x2

    new-array v3, v2, [Ljava/lang/Class;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    const/4 v5, 0x0

    aput-object v4, v3, v5

    const-class v4, Landroidx/versionedparcelable/b;

    const/4 v6, 0x1

    aput-object v4, v3, v6

    invoke-virtual {v0, v1, v3}, Ljava/lang/Class;->getDeclaredMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    const/4 v3, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p0, v2, v5

    aput-object p1, v2, v6

    .line 1462
    invoke-virtual {v1, v3, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1474
    nop

    .line 1475
    .end local v0    # "cls":Ljava/lang/Class;
    return-void

    .line 1472
    :catch_0
    move-exception v0

    .line 1473
    .local v0, "e":Ljava/lang/ClassNotFoundException;
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "VersionedParcel encountered ClassNotFoundException"

    invoke-direct {v1, v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    .line 1470
    .end local v0    # "e":Ljava/lang/ClassNotFoundException;
    :catch_1
    move-exception v0

    .line 1471
    .local v0, "e":Ljava/lang/NoSuchMethodException;
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "VersionedParcel encountered NoSuchMethodException"

    invoke-direct {v1, v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    .line 1465
    .end local v0    # "e":Ljava/lang/NoSuchMethodException;
    :catch_2
    move-exception v0

    .line 1466
    .local v0, "e":Ljava/lang/reflect/InvocationTargetException;
    invoke-virtual {v0}, Ljava/lang/reflect/InvocationTargetException;->getCause()Ljava/lang/Throwable;

    move-result-object v1

    instance-of v1, v1, Ljava/lang/RuntimeException;

    if-eqz v1, :cond_0

    .line 1467
    invoke-virtual {v0}, Ljava/lang/reflect/InvocationTargetException;->getCause()Ljava/lang/Throwable;

    move-result-object v1

    check-cast v1, Ljava/lang/RuntimeException;

    throw v1

    .line 1469
    :cond_0
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "VersionedParcel encountered InvocationTargetException"

    invoke-direct {v1, v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    .line 1463
    .end local v0    # "e":Ljava/lang/reflect/InvocationTargetException;
    :catch_3
    move-exception v0

    .line 1464
    .local v0, "e":Ljava/lang/IllegalAccessException;
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "VersionedParcel encountered IllegalAccessException"

    invoke-direct {v1, v2, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method private static b(Landroidx/versionedparcelable/d;)Ljava/lang/Class;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Landroidx/versionedparcelable/d;",
            ">(TT;)",
            "Ljava/lang/Class;"
        }
    .end annotation

    .line 1479
    .local p0, "val":Landroidx/versionedparcelable/d;, "TT;"
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    .line 1480
    .local v0, "cls":Ljava/lang/Class;, "Ljava/lang/Class<+Landroidx/versionedparcelable/VersionedParcelable;>;"
    invoke-static {v0}, Landroidx/versionedparcelable/b;->a(Ljava/lang/Class;)Ljava/lang/Class;

    move-result-object v1

    return-object v1
.end method

.method private c(Landroidx/versionedparcelable/d;)V
    .locals 5
    .param p1, "p"    # Landroidx/versionedparcelable/d;

    .line 946
    const/4 v0, 0x0

    .line 948
    .local v0, "name":Ljava/lang/Class;
    :try_start_0
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-static {v1}, Landroidx/versionedparcelable/b;->a(Ljava/lang/Class;)Ljava/lang/Class;

    move-result-object v1
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-object v0, v1

    .line 952
    nop

    .line 953
    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Landroidx/versionedparcelable/b;->a(Ljava/lang/String;)V

    .line 954
    return-void

    .line 949
    :catch_0
    move-exception v1

    .line 950
    .local v1, "e":Ljava/lang/ClassNotFoundException;
    new-instance v2, Ljava/lang/RuntimeException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v4, " does not have a Parcelizer"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v2
.end method


# virtual methods
.method public a(II)I
    .locals 1
    .param p1, "def"    # I
    .param p2, "fieldId"    # I

    .line 373
    invoke-virtual {p0, p2}, Landroidx/versionedparcelable/b;->a(I)Z

    move-result v0

    if-nez v0, :cond_0

    .line 374
    return p1

    .line 376
    :cond_0
    invoke-virtual {p0}, Landroidx/versionedparcelable/b;->e()I

    move-result v0

    return v0
.end method

.method public a(Landroid/os/Parcelable;I)Landroid/os/Parcelable;
    .locals 1
    .param p2, "fieldId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Landroid/os/Parcelable;",
            ">(TT;I)TT;"
        }
    .end annotation

    .line 445
    .local p1, "def":Landroid/os/Parcelable;, "TT;"
    invoke-virtual {p0, p2}, Landroidx/versionedparcelable/b;->a(I)Z

    move-result v0

    if-nez v0, :cond_0

    .line 446
    return-object p1

    .line 448
    :cond_0
    invoke-virtual {p0}, Landroidx/versionedparcelable/b;->f()Landroid/os/Parcelable;

    move-result-object v0

    return-object v0
.end method

.method public a(Ljava/lang/String;I)Ljava/lang/String;
    .locals 1
    .param p1, "def"    # Ljava/lang/String;
    .param p2, "fieldId"    # I

    .line 415
    invoke-virtual {p0, p2}, Landroidx/versionedparcelable/b;->a(I)Z

    move-result v0

    if-nez v0, :cond_0

    .line 416
    return-object p1

    .line 418
    :cond_0
    invoke-virtual {p0}, Landroidx/versionedparcelable/b;->g()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected abstract a()V
.end method

.method protected abstract a(Landroid/os/Parcelable;)V
.end method

.method protected a(Landroidx/versionedparcelable/d;)V
    .locals 1
    .param p1, "p"    # Landroidx/versionedparcelable/d;

    .line 934
    if-nez p1, :cond_0

    .line 935
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Landroidx/versionedparcelable/b;->a(Ljava/lang/String;)V

    .line 936
    return-void

    .line 938
    :cond_0
    invoke-direct {p0, p1}, Landroidx/versionedparcelable/b;->c(Landroidx/versionedparcelable/d;)V

    .line 940
    invoke-virtual {p0}, Landroidx/versionedparcelable/b;->b()Landroidx/versionedparcelable/b;

    move-result-object v0

    .line 941
    .local v0, "subParcel":Landroidx/versionedparcelable/b;
    invoke-static {p1, v0}, Landroidx/versionedparcelable/b;->a(Landroidx/versionedparcelable/d;Landroidx/versionedparcelable/b;)V

    .line 942
    invoke-virtual {v0}, Landroidx/versionedparcelable/b;->a()V

    .line 943
    return-void
.end method

.method protected abstract a(Ljava/lang/String;)V
.end method

.method public a(ZZ)V
    .locals 0
    .param p1, "allowSerialization"    # Z
    .param p2, "ignoreParcelables"    # Z

    .line 242
    return-void
.end method

.method protected abstract a([B)V
.end method

.method protected abstract a(I)Z
.end method

.method public a([BI)[B
    .locals 1
    .param p1, "def"    # [B
    .param p2, "fieldId"    # I

    .line 436
    invoke-virtual {p0, p2}, Landroidx/versionedparcelable/b;->a(I)Z

    move-result v0

    if-nez v0, :cond_0

    .line 437
    return-object p1

    .line 439
    :cond_0
    invoke-virtual {p0}, Landroidx/versionedparcelable/b;->d()[B

    move-result-object v0

    return-object v0
.end method

.method protected abstract b()Landroidx/versionedparcelable/b;
.end method

.method protected abstract b(I)V
.end method

.method public b(II)V
    .locals 0
    .param p1, "val"    # I
    .param p2, "fieldId"    # I

    .line 298
    invoke-virtual {p0, p2}, Landroidx/versionedparcelable/b;->b(I)V

    .line 299
    invoke-virtual {p0, p1}, Landroidx/versionedparcelable/b;->c(I)V

    .line 300
    return-void
.end method

.method public b(Landroid/os/Parcelable;I)V
    .locals 0
    .param p1, "p"    # Landroid/os/Parcelable;
    .param p2, "fieldId"    # I

    .line 355
    invoke-virtual {p0, p2}, Landroidx/versionedparcelable/b;->b(I)V

    .line 356
    invoke-virtual {p0, p1}, Landroidx/versionedparcelable/b;->a(Landroid/os/Parcelable;)V

    .line 357
    return-void
.end method

.method public b(Ljava/lang/String;I)V
    .locals 0
    .param p1, "val"    # Ljava/lang/String;
    .param p2, "fieldId"    # I

    .line 334
    invoke-virtual {p0, p2}, Landroidx/versionedparcelable/b;->b(I)V

    .line 335
    invoke-virtual {p0, p1}, Landroidx/versionedparcelable/b;->a(Ljava/lang/String;)V

    .line 336
    return-void
.end method

.method public b([BI)V
    .locals 0
    .param p1, "b"    # [B
    .param p2, "fieldId"    # I

    .line 277
    invoke-virtual {p0, p2}, Landroidx/versionedparcelable/b;->b(I)V

    .line 278
    invoke-virtual {p0, p1}, Landroidx/versionedparcelable/b;->a([B)V

    .line 279
    return-void
.end method

.method protected abstract c(I)V
.end method

.method public c()Z
    .locals 1

    .line 79
    const/4 v0, 0x0

    return v0
.end method

.method protected abstract d()[B
.end method

.method protected abstract e()I
.end method

.method protected abstract f()Landroid/os/Parcelable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Landroid/os/Parcelable;",
            ">()TT;"
        }
    .end annotation
.end method

.method protected abstract g()Ljava/lang/String;
.end method

.method protected h()Landroidx/versionedparcelable/d;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Landroidx/versionedparcelable/d;",
            ">()TT;"
        }
    .end annotation

    .line 1382
    invoke-virtual {p0}, Landroidx/versionedparcelable/b;->g()Ljava/lang/String;

    move-result-object v0

    .line 1383
    .local v0, "name":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 1384
    const/4 v1, 0x0

    return-object v1

    .line 1386
    :cond_0
    invoke-virtual {p0}, Landroidx/versionedparcelable/b;->b()Landroidx/versionedparcelable/b;

    move-result-object v1

    invoke-static {v0, v1}, Landroidx/versionedparcelable/b;->a(Ljava/lang/String;Landroidx/versionedparcelable/b;)Landroidx/versionedparcelable/d;

    move-result-object v1

    return-object v1
.end method
