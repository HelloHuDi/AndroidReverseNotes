.class Landroid/support/v4/app/k$a;
.super Landroid/support/v4/app/n;
.source ""


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v4/app/k;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "a"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/support/v4/app/n<",
        "Landroid/support/v4/app/k;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic f:Landroid/support/v4/app/k;


# direct methods
.method public constructor <init>(Landroid/support/v4/app/k;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v4/app/k;

    .line 958
    iput-object p1, p0, Landroid/support/v4/app/k$a;->f:Landroid/support/v4/app/k;

    .line 959
    invoke-direct {p0, p1}, Landroid/support/v4/app/n;-><init>(Landroid/support/v4/app/k;)V

    .line 960
    return-void
.end method


# virtual methods
.method public a(I)Landroid/view/View;
    .locals 1
    .param p1, "id"    # I

    .line 1038
    iget-object v0, p0, Landroid/support/v4/app/k$a;->f:Landroid/support/v4/app/k;

    invoke-virtual {v0, p1}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public a(Landroid/support/v4/app/i;)V
    .locals 1
    .param p1, "fragment"    # Landroid/support/v4/app/i;

    .line 1032
    iget-object v0, p0, Landroid/support/v4/app/k$a;->f:Landroid/support/v4/app/k;

    invoke-virtual {v0, p1}, Landroid/support/v4/app/k;->a(Landroid/support/v4/app/i;)V

    .line 1033
    return-void
.end method

.method public a(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    .locals 1
    .param p1, "prefix"    # Ljava/lang/String;
    .param p2, "fd"    # Ljava/io/FileDescriptor;
    .param p3, "writer"    # Ljava/io/PrintWriter;
    .param p4, "args"    # [Ljava/lang/String;

    .line 964
    iget-object v0, p0, Landroid/support/v4/app/k$a;->f:Landroid/support/v4/app/k;

    invoke-virtual {v0, p1, p2, p3, p4}, Landroid/support/v4/app/k;->dump(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V

    .line 965
    return-void
.end method

.method public a()Z
    .locals 2

    .line 1043
    iget-object v0, p0, Landroid/support/v4/app/k$a;->f:Landroid/support/v4/app/k;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    .line 1044
    .local v0, "w":Landroid/view/Window;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/view/Window;->peekDecorView()Landroid/view/View;

    move-result-object v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    goto :goto_0

    :cond_0
    const/4 v1, 0x0

    :goto_0
    return v1
.end method

.method public b(Landroid/support/v4/app/i;)Z
    .locals 1
    .param p1, "fragment"    # Landroid/support/v4/app/i;

    .line 969
    iget-object v0, p0, Landroid/support/v4/app/k$a;->f:Landroid/support/v4/app/k;

    invoke-virtual {v0}, Landroid/app/Activity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public f()Landroid/view/LayoutInflater;
    .locals 2

    .line 974
    iget-object v0, p0, Landroid/support/v4/app/k$a;->f:Landroid/support/v4/app/k;

    invoke-virtual {v0}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    iget-object v1, p0, Landroid/support/v4/app/k$a;->f:Landroid/support/v4/app/k;

    invoke-virtual {v0, v1}, Landroid/view/LayoutInflater;->cloneInContext(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    return-object v0
.end method

.method public g()I
    .locals 2

    .line 1026
    iget-object v0, p0, Landroid/support/v4/app/k$a;->f:Landroid/support/v4/app/k;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    .line 1027
    .local v0, "w":Landroid/view/Window;
    if-nez v0, :cond_0

    const/4 v1, 0x0

    goto :goto_0

    :cond_0
    invoke-virtual {v0}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v1

    iget v1, v1, Landroid/view/WindowManager$LayoutParams;->windowAnimations:I

    :goto_0
    return v1
.end method

.method public h()Z
    .locals 1

    .line 1021
    iget-object v0, p0, Landroid/support/v4/app/k$a;->f:Landroid/support/v4/app/k;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    goto :goto_0

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0
.end method

.method public i()V
    .locals 1

    .line 984
    iget-object v0, p0, Landroid/support/v4/app/k$a;->f:Landroid/support/v4/app/k;

    invoke-virtual {v0}, Landroid/support/v4/app/k;->g()V

    .line 985
    return-void
.end method
