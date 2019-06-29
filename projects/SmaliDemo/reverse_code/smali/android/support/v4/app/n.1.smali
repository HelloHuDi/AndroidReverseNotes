.class public abstract Landroid/support/v4/app/n;
.super Landroid/support/v4/app/l;
.source ""


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<E:",
        "Ljava/lang/Object;",
        ">",
        "Landroid/support/v4/app/l;"
    }
.end annotation


# instance fields
.field private final a:Landroid/app/Activity;

.field private final b:Landroid/content/Context;

.field private final c:Landroid/os/Handler;

.field private final d:I

.field final e:Landroid/support/v4/app/v;


# direct methods
.method constructor <init>(Landroid/app/Activity;Landroid/content/Context;Landroid/os/Handler;I)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "handler"    # Landroid/os/Handler;
    .param p4, "windowAnimations"    # I

    .line 61
    .local p0, "this":Landroid/support/v4/app/n;, "Landroid/support/v4/app/FragmentHostCallback<TE;>;"
    invoke-direct {p0}, Landroid/support/v4/app/l;-><init>()V

    .line 48
    new-instance v0, Landroid/support/v4/app/v;

    invoke-direct {v0}, Landroid/support/v4/app/v;-><init>()V

    iput-object v0, p0, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    .line 62
    iput-object p1, p0, Landroid/support/v4/app/n;->a:Landroid/app/Activity;

    .line 63
    const-string v0, "context == null"

    invoke-static {p2, v0}, La/b/c/f/l;->a(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-object v0, p2

    check-cast v0, Landroid/content/Context;

    iput-object v0, p0, Landroid/support/v4/app/n;->b:Landroid/content/Context;

    .line 64
    const-string v0, "handler == null"

    invoke-static {p3, v0}, La/b/c/f/l;->a(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-object v0, p3

    check-cast v0, Landroid/os/Handler;

    iput-object v0, p0, Landroid/support/v4/app/n;->c:Landroid/os/Handler;

    .line 65
    iput p4, p0, Landroid/support/v4/app/n;->d:I

    .line 66
    return-void
.end method

.method constructor <init>(Landroid/support/v4/app/k;)V
    .locals 2
    .param p1, "activity"    # Landroid/support/v4/app/k;

    .line 57
    .local p0, "this":Landroid/support/v4/app/n;, "Landroid/support/v4/app/FragmentHostCallback<TE;>;"
    iget-object v0, p1, Landroid/support/v4/app/k;->c:Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-direct {p0, p1, p1, v0, v1}, Landroid/support/v4/app/n;-><init>(Landroid/app/Activity;Landroid/content/Context;Landroid/os/Handler;I)V

    .line 58
    return-void
.end method


# virtual methods
.method abstract a(Landroid/support/v4/app/i;)V
.end method

.method public abstract a(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
.end method

.method b()Landroid/app/Activity;
    .locals 1

    .line 190
    .local p0, "this":Landroid/support/v4/app/n;, "Landroid/support/v4/app/FragmentHostCallback<TE;>;"
    iget-object v0, p0, Landroid/support/v4/app/n;->a:Landroid/app/Activity;

    return-object v0
.end method

.method public abstract b(Landroid/support/v4/app/i;)Z
.end method

.method c()Landroid/content/Context;
    .locals 1

    .line 195
    .local p0, "this":Landroid/support/v4/app/n;, "Landroid/support/v4/app/FragmentHostCallback<TE;>;"
    iget-object v0, p0, Landroid/support/v4/app/n;->b:Landroid/content/Context;

    return-object v0
.end method

.method d()Landroid/support/v4/app/v;
    .locals 1

    .line 204
    .local p0, "this":Landroid/support/v4/app/n;, "Landroid/support/v4/app/FragmentHostCallback<TE;>;"
    iget-object v0, p0, Landroid/support/v4/app/n;->e:Landroid/support/v4/app/v;

    return-object v0
.end method

.method e()Landroid/os/Handler;
    .locals 1

    .line 200
    .local p0, "this":Landroid/support/v4/app/n;, "Landroid/support/v4/app/FragmentHostCallback<TE;>;"
    iget-object v0, p0, Landroid/support/v4/app/n;->c:Landroid/os/Handler;

    return-object v0
.end method

.method public abstract f()Landroid/view/LayoutInflater;
.end method

.method public abstract g()I
.end method

.method public abstract h()Z
.end method

.method public abstract i()V
.end method
