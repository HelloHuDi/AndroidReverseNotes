.class Landroid/support/v4/app/LoaderManagerImpl$LoaderViewModel;
.super Landroid/arch/lifecycle/q;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v4/app/LoaderManagerImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "LoaderViewModel"
.end annotation


# static fields
.field private static final a:Landroid/arch/lifecycle/r$a;


# instance fields
.field private b:La/b/c/f/n;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "La/b/c/f/n<",
            "Landroid/support/v4/app/LoaderManagerImpl$a;",
            ">;"
        }
    .end annotation
.end field

.field private c:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .line 281
    new-instance v0, Landroid/support/v4/app/S;

    invoke-direct {v0}, Landroid/support/v4/app/S;-><init>()V

    sput-object v0, Landroid/support/v4/app/LoaderManagerImpl$LoaderViewModel;->a:Landroid/arch/lifecycle/r$a;

    return-void
.end method

.method constructor <init>()V
    .locals 1

    .line 280
    invoke-direct {p0}, Landroid/arch/lifecycle/q;-><init>()V

    .line 295
    new-instance v0, La/b/c/f/n;

    invoke-direct {v0}, La/b/c/f/n;-><init>()V

    iput-object v0, p0, Landroid/support/v4/app/LoaderManagerImpl$LoaderViewModel;->b:La/b/c/f/n;

    .line 296
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v4/app/LoaderManagerImpl$LoaderViewModel;->c:Z

    return-void
.end method

.method static a(Landroid/arch/lifecycle/s;)Landroid/support/v4/app/LoaderManagerImpl$LoaderViewModel;
    .locals 2
    .param p0, "viewModelStore"    # Landroid/arch/lifecycle/s;

    .line 292
    new-instance v0, Landroid/arch/lifecycle/r;

    sget-object v1, Landroid/support/v4/app/LoaderManagerImpl$LoaderViewModel;->a:Landroid/arch/lifecycle/r$a;

    invoke-direct {v0, p0, v1}, Landroid/arch/lifecycle/r;-><init>(Landroid/arch/lifecycle/s;Landroid/arch/lifecycle/r$a;)V

    const-class v1, Landroid/support/v4/app/LoaderManagerImpl$LoaderViewModel;

    invoke-virtual {v0, v1}, Landroid/arch/lifecycle/r;->a(Ljava/lang/Class;)Landroid/arch/lifecycle/q;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/LoaderManagerImpl$LoaderViewModel;

    return-object v0
.end method


# virtual methods
.method protected a()V
    .locals 2

    .line 344
    invoke-super {p0}, Landroid/arch/lifecycle/q;->a()V

    .line 345
    iget-object v0, p0, Landroid/support/v4/app/LoaderManagerImpl$LoaderViewModel;->b:La/b/c/f/n;

    invoke-virtual {v0}, La/b/c/f/n;->b()I

    move-result v0

    .line 346
    .local v0, "size":I
    const/4 v1, 0x0

    .local v1, "index":I
    if-lt v1, v0, :cond_0

    .line 350
    .end local v1    # "index":I
    iget-object v1, p0, Landroid/support/v4/app/LoaderManagerImpl$LoaderViewModel;->b:La/b/c/f/n;

    invoke-virtual {v1}, La/b/c/f/n;->a()V

    .line 351
    return-void

    .line 347
    .end local v0    # "size":I
    .end local p0    # "this":Landroid/support/v4/app/LoaderManagerImpl$LoaderViewModel;
    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/LoaderManagerImpl$LoaderViewModel;->b:La/b/c/f/n;

    invoke-virtual {v0, v1}, La/b/c/f/n;->e(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/LoaderManagerImpl$a;

    .line 348
    .local v0, "info":Landroid/support/v4/app/LoaderManagerImpl$a;
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/support/v4/app/LoaderManagerImpl$a;->a(Z)La/b/c/a/b;

    .end local v0    # "info":Landroid/support/v4/app/LoaderManagerImpl$a;
    const/4 v0, 0x0

    throw v0
.end method

.method public a(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    .locals 3
    .param p1, "prefix"    # Ljava/lang/String;
    .param p2, "fd"    # Ljava/io/FileDescriptor;
    .param p3, "writer"    # Ljava/io/PrintWriter;
    .param p4, "args"    # [Ljava/lang/String;

    .line 354
    iget-object v0, p0, Landroid/support/v4/app/LoaderManagerImpl$LoaderViewModel;->b:La/b/c/f/n;

    invoke-virtual {v0}, La/b/c/f/n;->b()I

    move-result v0

    if-lez v0, :cond_1

    .line 355
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "Loaders:"

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    .line 356
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    const-string v1, "    "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 357
    .local v0, "innerPrefix":Ljava/lang/String;
    const/4 v1, 0x0

    .local v1, "i":I
    iget-object v2, p0, Landroid/support/v4/app/LoaderManagerImpl$LoaderViewModel;->b:La/b/c/f/n;

    invoke-virtual {v2}, La/b/c/f/n;->b()I

    move-result v2

    if-lt v1, v2, :cond_0

    goto :goto_0

    .line 358
    .end local v0    # "innerPrefix":Ljava/lang/String;
    .end local v1    # "i":I
    .end local p0    # "this":Landroid/support/v4/app/LoaderManagerImpl$LoaderViewModel;
    .end local p1    # "prefix":Ljava/lang/String;
    .end local p2    # "fd":Ljava/io/FileDescriptor;
    .end local p3    # "writer":Ljava/io/PrintWriter;
    .end local p4    # "args":[Ljava/lang/String;
    :cond_0
    iget-object v2, p0, Landroid/support/v4/app/LoaderManagerImpl$LoaderViewModel;->b:La/b/c/f/n;

    invoke-virtual {v2, v1}, La/b/c/f/n;->e(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/support/v4/app/LoaderManagerImpl$a;

    .line 359
    .local v2, "info":Landroid/support/v4/app/LoaderManagerImpl$a;
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string p1, "  #"

    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-object p1, p0, Landroid/support/v4/app/LoaderManagerImpl$LoaderViewModel;->b:La/b/c/f/n;

    invoke-virtual {p1, v1}, La/b/c/f/n;->c(I)I

    move-result p1

    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(I)V

    .line 360
    const-string p1, ": "

    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    invoke-virtual {v2}, Landroid/support/v4/app/LoaderManagerImpl$a;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->println(Ljava/lang/String;)V

    .line 361
    invoke-virtual {v2, v0, p2, p3, p4}, Landroid/support/v4/app/LoaderManagerImpl$a;->a(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V

    .end local v2    # "info":Landroid/support/v4/app/LoaderManagerImpl$a;
    const/4 p1, 0x0

    throw p1

    .line 364
    .restart local p1    # "prefix":Ljava/lang/String;
    .restart local p2    # "fd":Ljava/io/FileDescriptor;
    .restart local p3    # "writer":Ljava/io/PrintWriter;
    .restart local p4    # "args":[Ljava/lang/String;
    :cond_1
    :goto_0
    return-void
.end method

.method b()V
    .locals 3

    .line 335
    iget-object v0, p0, Landroid/support/v4/app/LoaderManagerImpl$LoaderViewModel;->b:La/b/c/f/n;

    invoke-virtual {v0}, La/b/c/f/n;->b()I

    move-result v0

    .line 336
    .local v0, "size":I
    const/4 v1, 0x0

    .local v1, "index":I
    :goto_0
    if-ge v1, v0, :cond_0

    .line 337
    iget-object v2, p0, Landroid/support/v4/app/LoaderManagerImpl$LoaderViewModel;->b:La/b/c/f/n;

    invoke-virtual {v2, v1}, La/b/c/f/n;->e(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/support/v4/app/LoaderManagerImpl$a;

    .line 338
    .local v2, "info":Landroid/support/v4/app/LoaderManagerImpl$a;
    invoke-virtual {v2}, Landroid/support/v4/app/LoaderManagerImpl$a;->d()V

    .line 336
    .end local v2    # "info":Landroid/support/v4/app/LoaderManagerImpl$a;
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 340
    .end local v1    # "index":I
    :cond_0
    return-void
.end method
