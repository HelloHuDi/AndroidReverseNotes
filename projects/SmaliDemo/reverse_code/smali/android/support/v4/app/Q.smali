.class public abstract Landroid/support/v4/app/Q;
.super Ljava/lang/Object;
.source ""


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    return-void
.end method

.method public static a(Landroid/arch/lifecycle/f;)Landroid/support/v4/app/Q;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T::",
            "Landroid/arch/lifecycle/f;",
            ":",
            "Landroid/arch/lifecycle/t;",
            ">(TT;)",
            "Landroid/support/v4/app/Q;"
        }
    .end annotation

    .line 128
    .local p0, "owner":Landroid/arch/lifecycle/f;, "TT;"
    new-instance v0, Landroid/support/v4/app/LoaderManagerImpl;

    move-object v1, p0

    check-cast v1, Landroid/arch/lifecycle/t;

    invoke-interface {v1}, Landroid/arch/lifecycle/t;->b()Landroid/arch/lifecycle/s;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Landroid/support/v4/app/LoaderManagerImpl;-><init>(Landroid/arch/lifecycle/f;Landroid/arch/lifecycle/s;)V

    return-object v0
.end method


# virtual methods
.method public abstract a()V
.end method

.method public abstract a(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end method
