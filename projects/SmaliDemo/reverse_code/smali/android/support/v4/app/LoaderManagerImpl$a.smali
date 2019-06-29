.class public Landroid/support/v4/app/LoaderManagerImpl$a;
.super Landroid/arch/lifecycle/m;
.source ""

# interfaces
.implements La/b/c/a/b$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroid/support/v4/app/LoaderManagerImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "a"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<D:",
        "Ljava/lang/Object;",
        ">",
        "Landroid/arch/lifecycle/m<",
        "TD;>;",
        "La/b/c/a/b$a<",
        "TD;>;"
    }
.end annotation


# instance fields
.field private final k:I

.field private final l:Landroid/os/Bundle;

.field private final m:La/b/c/a/b;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "La/b/c/a/b<",
            "TD;>;"
        }
    .end annotation
.end field

.field private n:Landroid/arch/lifecycle/f;

.field private o:Landroid/support/v4/app/LoaderManagerImpl$b;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/app/LoaderManagerImpl$b<",
            "TD;>;"
        }
    .end annotation
.end field

.field private p:La/b/c/a/b;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "La/b/c/a/b<",
            "TD;>;"
        }
    .end annotation
.end field


# virtual methods
.method a(Z)La/b/c/a/b;
    .locals 1
    .param p1, "reset"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z)",
            "La/b/c/a/b<",
            "TD;>;"
        }
    .end annotation

    .line 149
    .local p0, "this":Landroid/support/v4/app/LoaderManagerImpl$a;, "Landroid/support/v4/app/LoaderManagerImpl$LoaderInfo<TD;>;"
    sget-boolean p1, Landroid/support/v4/app/LoaderManagerImpl;->a:Z

    if-eqz p1, :cond_0

    .end local p0    # "this":Landroid/support/v4/app/LoaderManagerImpl$a;, "Landroid/support/v4/app/LoaderManagerImpl$LoaderInfo<TD;>;"
    new-instance p1, Ljava/lang/StringBuilder;

    invoke-direct {p1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v0, "  Destroying: "

    invoke-virtual {p1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {p1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    const-string v0, "LoaderManager"

    invoke-static {v0, p1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 151
    :cond_0
    iget-object p1, p0, Landroid/support/v4/app/LoaderManagerImpl$a;->m:La/b/c/a/b;

    invoke-virtual {p1}, La/b/c/a/b;->a()Z

    const/4 p1, 0x0

    throw p1
.end method

.method public a(Landroid/arch/lifecycle/n;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/arch/lifecycle/n<",
            "-TD;>;)V"
        }
    .end annotation

    .line 134
    .local p0, "this":Landroid/support/v4/app/LoaderManagerImpl$a;, "Landroid/support/v4/app/LoaderManagerImpl$LoaderInfo<TD;>;"
    .local p1, "observer":Landroid/arch/lifecycle/n;, "Landroid/arch/lifecycle/Observer<-TD;>;"
    invoke-super {p0, p1}, Landroid/arch/lifecycle/LiveData;->a(Landroid/arch/lifecycle/n;)V

    .line 136
    const/4 v0, 0x0

    iput-object v0, p0, Landroid/support/v4/app/LoaderManagerImpl$a;->n:Landroid/arch/lifecycle/f;

    .line 137
    iput-object v0, p0, Landroid/support/v4/app/LoaderManagerImpl$a;->o:Landroid/support/v4/app/LoaderManagerImpl$b;

    .line 138
    return-void
.end method

.method public a(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TD;)V"
        }
    .end annotation

    .line 189
    .local p0, "this":Landroid/support/v4/app/LoaderManagerImpl$a;, "Landroid/support/v4/app/LoaderManagerImpl$LoaderInfo<TD;>;"
    .local p1, "value":Ljava/lang/Object;, "TD;"
    invoke-super {p0, p1}, Landroid/arch/lifecycle/m;->a(Ljava/lang/Object;)V

    .line 191
    iget-object v0, p0, Landroid/support/v4/app/LoaderManagerImpl$a;->p:La/b/c/a/b;

    if-nez v0, :cond_0

    .line 195
    return-void

    .line 192
    .end local p0    # "this":Landroid/support/v4/app/LoaderManagerImpl$a;, "Landroid/support/v4/app/LoaderManagerImpl$LoaderInfo<TD;>;"
    .end local p1    # "value":Ljava/lang/Object;, "TD;"
    :cond_0
    invoke-virtual {v0}, La/b/c/a/b;->b()V

    const/4 p1, 0x0

    throw p1
.end method

.method public a(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V
    .locals 2
    .param p1, "prefix"    # Ljava/lang/String;
    .param p2, "fd"    # Ljava/io/FileDescriptor;
    .param p3, "writer"    # Ljava/io/PrintWriter;
    .param p4, "args"    # [Ljava/lang/String;

    .line 212
    .local p0, "this":Landroid/support/v4/app/LoaderManagerImpl$a;, "Landroid/support/v4/app/LoaderManagerImpl$LoaderInfo<TD;>;"
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mId="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget v0, p0, Landroid/support/v4/app/LoaderManagerImpl$a;->k:I

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(I)V

    .line 213
    const-string v0, " mArgs="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-object v0, p0, Landroid/support/v4/app/LoaderManagerImpl$a;->l:Landroid/os/Bundle;

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/Object;)V

    .line 214
    invoke-virtual {p3, p1}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    const-string v0, "mLoader="

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->print(Ljava/lang/String;)V

    iget-object v0, p0, Landroid/support/v4/app/LoaderManagerImpl$a;->m:La/b/c/a/b;

    invoke-virtual {p3, v0}, Ljava/io/PrintWriter;->println(Ljava/lang/Object;)V

    .line 215
    iget-object v0, p0, Landroid/support/v4/app/LoaderManagerImpl$a;->m:La/b/c/a/b;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .end local p1    # "prefix":Ljava/lang/String;
    const-string p1, "  "

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    invoke-virtual {v0, p1, p2, p3, p4}, La/b/c/a/b;->a(Ljava/lang/String;Ljava/io/FileDescriptor;Ljava/io/PrintWriter;[Ljava/lang/String;)V

    .end local p0    # "this":Landroid/support/v4/app/LoaderManagerImpl$a;, "Landroid/support/v4/app/LoaderManagerImpl$LoaderInfo<TD;>;"
    .end local p2    # "fd":Ljava/io/FileDescriptor;
    .end local p3    # "writer":Ljava/io/PrintWriter;
    .end local p4    # "args":[Ljava/lang/String;
    const/4 p1, 0x0

    throw p1
.end method

.method protected b()V
    .locals 2

    .line 76
    .local p0, "this":Landroid/support/v4/app/LoaderManagerImpl$a;, "Landroid/support/v4/app/LoaderManagerImpl$LoaderInfo<TD;>;"
    sget-boolean v0, Landroid/support/v4/app/LoaderManagerImpl;->a:Z

    if-eqz v0, :cond_0

    .end local p0    # "this":Landroid/support/v4/app/LoaderManagerImpl$a;, "Landroid/support/v4/app/LoaderManagerImpl$LoaderInfo<TD;>;"
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "  Starting: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "LoaderManager"

    invoke-static {v1, v0}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 77
    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/LoaderManagerImpl$a;->m:La/b/c/a/b;

    invoke-virtual {v0}, La/b/c/a/b;->c()V

    const/4 v0, 0x0

    throw v0
.end method

.method protected c()V
    .locals 2

    .line 82
    .local p0, "this":Landroid/support/v4/app/LoaderManagerImpl$a;, "Landroid/support/v4/app/LoaderManagerImpl$LoaderInfo<TD;>;"
    sget-boolean v0, Landroid/support/v4/app/LoaderManagerImpl;->a:Z

    if-eqz v0, :cond_0

    .end local p0    # "this":Landroid/support/v4/app/LoaderManagerImpl$a;, "Landroid/support/v4/app/LoaderManagerImpl$LoaderInfo<TD;>;"
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "  Stopping: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "LoaderManager"

    invoke-static {v1, v0}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 83
    :cond_0
    iget-object v0, p0, Landroid/support/v4/app/LoaderManagerImpl$a;->m:La/b/c/a/b;

    invoke-virtual {v0}, La/b/c/a/b;->d()V

    const/4 v0, 0x0

    throw v0
.end method

.method d()V
    .locals 2

    .line 111
    .local p0, "this":Landroid/support/v4/app/LoaderManagerImpl$a;, "Landroid/support/v4/app/LoaderManagerImpl$LoaderInfo<TD;>;"
    iget-object v0, p0, Landroid/support/v4/app/LoaderManagerImpl$a;->n:Landroid/arch/lifecycle/f;

    .line 112
    .local v0, "lifecycleOwner":Landroid/arch/lifecycle/f;
    iget-object v1, p0, Landroid/support/v4/app/LoaderManagerImpl$a;->o:Landroid/support/v4/app/LoaderManagerImpl$b;

    .line 113
    .local v1, "observer":Landroid/support/v4/app/LoaderManagerImpl$b;, "Landroid/support/v4/app/LoaderManagerImpl$LoaderObserver<TD;>;"
    if-eqz v0, :cond_0

    if-eqz v1, :cond_0

    .line 118
    invoke-super {p0, v1}, Landroid/arch/lifecycle/LiveData;->a(Landroid/arch/lifecycle/n;)V

    .line 119
    invoke-virtual {p0, v0, v1}, Landroid/arch/lifecycle/LiveData;->a(Landroid/arch/lifecycle/f;Landroid/arch/lifecycle/n;)V

    .line 121
    :cond_0
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .line 199
    .local p0, "this":Landroid/support/v4/app/LoaderManagerImpl$a;, "Landroid/support/v4/app/LoaderManagerImpl$LoaderInfo<TD;>;"
    new-instance v0, Ljava/lang/StringBuilder;

    const/16 v1, 0x40

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 200
    .local v0, "sb":Ljava/lang/StringBuilder;
    const-string v1, "LoaderInfo{"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 201
    invoke-static {p0}, Ljava/lang/System;->identityHashCode(Ljava/lang/Object;)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 202
    const-string v1, " #"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 203
    iget v1, p0, Landroid/support/v4/app/LoaderManagerImpl$a;->k:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 204
    const-string v1, " : "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 205
    iget-object v1, p0, Landroid/support/v4/app/LoaderManagerImpl$a;->m:La/b/c/a/b;

    invoke-static {v1, v0}, La/b/c/f/f;->a(Ljava/lang/Object;Ljava/lang/StringBuilder;)V

    .line 206
    const-string v1, "}}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 207
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
