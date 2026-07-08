public final String signedRequest(String v, String v2, String v3, Map<String, String> v4, Map<String, String> v5, String v6, boolean v7) {
            this = this;
            r1 = r18
            r2 = r19
            r0 = r20
            r3 = r21
            r4 = r22
            r5 = r23
            r6 = r24
            java.lang.String r7 = "apiBase"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r7)
            java.lang.String r7 = "endpointPath"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r7)
            java.lang.String r7 = "method"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r7)
            java.lang.String r7 = "query"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r7)
            java.lang.String r7 = "headers"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r7)
            java.util.Locale r7 = java.util.Locale.ROOT
            java.lang.String r3 = r3.toUpperCase(r7)
            java.lang.String r7 = "toUpperCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r7)
            java.lang.String r7 = r1.ensureSlashStart(r0)
            java.lang.String r0 = r18.deriveRoutePrefix(r19)
            java.lang.String r8 = r1.joinPath(r0, r7)
            boolean r9 = r1.isIdempotentMethod(r3)
            if (r9 == 0) goto L48
            r0 = 3
            r11 = r0
            goto L49
        L48:
            r11 = 2
        L49:
            r0 = 1
            if (r0 > r11) goto L1f1
            r13 = r0
            r0 = 0
        L4e:
            long r14 = java.lang.System.currentTimeMillis()
            r16 = 1000(0x3e8, double:4.94E-321)
            long r14 = r14 / r16
            java.lang.String r14 = java.lang.String.valueOf(r14)
            java.lang.String r15 = r18.makeNonce()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.StringBuilder r10 = r10.append(r3)
            java.lang.String r12 = "\n"
            java.lang.StringBuilder r10 = r10.append(r12)
            java.lang.StringBuilder r10 = r10.append(r8)
            java.lang.StringBuilder r10 = r10.append(r12)
            java.lang.StringBuilder r10 = r10.append(r14)
            java.lang.StringBuilder r10 = r10.append(r12)
            java.lang.StringBuilder r10 = r10.append(r15)
            java.lang.String r10 = r10.toString()
            java.lang.String r10 = r1.hmacSha256Hex(r10)
            java.lang.String r12 = r1.buildUrl(r2, r7, r4)
            r16 = r0
            okhttp3.Request$Builder r0 = new okhttp3.Request$Builder
            r0.<init>()
            okhttp3.Request$Builder r0 = r0.url(r12)
            java.lang.String r12 = "x-fk-app-id"
            java.lang.String r2 = "filmkiotv"
            okhttp3.Request$Builder r0 = r0.header(r12, r2)
            java.lang.String r2 = "x-fk-ts"
            okhttp3.Request$Builder r0 = r0.header(r2, r14)
            java.lang.String r2 = "x-fk-nonce"
            okhttp3.Request$Builder r0 = r0.header(r2, r15)
            java.lang.String r2 = "x-fk-sign"
            okhttp3.Request$Builder r0 = r0.header(r2, r10)
            java.lang.String r2 = r18.buildUserAgent()
            java.lang.String r10 = "User-Agent"
            okhttp3.Request$Builder r0 = r0.header(r10, r2)
            com.filmkio.AppState r2 = com.filmkio.AppState.INSTANCE
            java.lang.String r2 = r2.getClientName()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r10 = kotlin.text.StringsKt.isBlank(r2)
            if (r10 == 0) goto Ld0
            java.lang.String r2 = "FilmKioTV"
        Ld0:
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r10 = "X-FilmKio-Client"
            okhttp3.Request$Builder r0 = r0.header(r10, r2)
            com.filmkio.AppState r2 = com.filmkio.AppState.INSTANCE
            java.lang.String r2 = r2.getClientPlatform()
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            boolean r10 = kotlin.text.StringsKt.isBlank(r2)
            if (r10 == 0) goto Le9
            java.lang.String r2 = "tv"
        Le9:
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r10 = "x-fk-platform"
            okhttp3.Request$Builder r0 = r0.header(r10, r2)
            java.util.Set r2 = r23.entrySet()
            java.util.Iterator r2 = r2.iterator()
        Lfa:
            boolean r10 = r2.hasNext()
            if (r10 == 0) goto L116
            java.lang.Object r10 = r2.next()
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10
            java.lang.Object r12 = r10.getKey()
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r10 = r10.getValue()
            java.lang.String r10 = (java.lang.String) r10
            r0.header(r12, r10)
            goto Lfa
        L116:
            java.lang.String r2 = ""
            java.lang.String r10 = "application/json; charset=utf-8"
            if (r6 == 0) goto L129
            okhttp3.RequestBody$Companion r12 = okhttp3.RequestBody.Companion
            okhttp3.MediaType$Companion r14 = okhttp3.MediaType.Companion
            okhttp3.MediaType r10 = r14.get(r10)
            okhttp3.RequestBody r10 = r12.create(r6, r10)
            goto L148
        L129:
            java.lang.String r12 = "GET"
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r12)
            if (r12 != 0) goto L147
            java.lang.String r12 = "HEAD"
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r12)
            if (r12 == 0) goto L13a
            goto L147
        L13a:
            okhttp3.RequestBody$Companion r12 = okhttp3.RequestBody.Companion
            okhttp3.MediaType$Companion r14 = okhttp3.MediaType.Companion
            okhttp3.MediaType r10 = r14.get(r10)
            okhttp3.RequestBody r10 = r12.create(r2, r10)
            goto L148
        L147:
            r10 = 0
        L148:
            okhttp3.Request$Builder r0 = r0.method(r3, r10)
            okhttp3.Request r0 = r0.build()
            okhttp3.OkHttpClient r10 = r18.getClient()     // Catch: java.lang.Throwable -> L1ce
            okhttp3.Call r0 = r10.newCall(r0)     // Catch: java.lang.Throwable -> L1ce
            okhttp3.Response r0 = r0.execute()     // Catch: java.lang.Throwable -> L1ce
            r10 = r0
            java.io.Closeable r10 = (java.io.Closeable) r10     // Catch: java.lang.Throwable -> L1ce
            r0 = r10
            okhttp3.Response r0 = (okhttp3.Response) r0     // Catch: java.lang.Throwable -> L1c2
            okhttp3.ResponseBody r12 = r0.body()     // Catch: java.lang.Throwable -> L1c2
            if (r12 == 0) goto L175
            java.lang.String r12 = r12.string()     // Catch: java.lang.Throwable -> L171
            if (r12 != 0) goto L16f
            goto L175
        L16f:
            r2 = r12
            goto L175
        L171:
            r0 = move-exception
            r2 = r0
            r14 = 2
            goto L1c5
        L175:
            if (r25 == 0) goto L180
            com.filmkio.MobileSessionInvalidation r12 = com.filmkio.MobileSessionInvalidation.INSTANCE     // Catch: java.lang.Throwable -> L171
            int r14 = r0.code()     // Catch: java.lang.Throwable -> L171
            r12.onApiResponse(r14, r2, r5)     // Catch: java.lang.Throwable -> L171
        L180:
            boolean r12 = r0.isSuccessful()     // Catch: java.lang.Throwable -> L1c2
            if (r12 == 0) goto L18b
            r12 = 0
            kotlin.p007io.CloseableKt.closeFinally(r10, r12)     // Catch: java.lang.Throwable -> L1ce
            return r2
        L18b:
            com.filmkio.nativescreen.net.FkApiClient r12 = com.filmkio.nativescreen.net.FkApiClient.INSTANCE     // Catch: java.lang.Throwable -> L1c2
            int r14 = r0.code()     // Catch: java.lang.Throwable -> L1c2
            boolean r14 = r12.shouldRetryHttpStatus(r14, r9, r13, r11)     // Catch: java.lang.Throwable -> L1c2
            if (r14 == 0) goto L1af
            java.lang.String r2 = "Retry-After"
            r14 = 2
            r15 = 0
            java.lang.String r0 = okhttp3.Response.header$default(r0, r2, r15, r14, r15)     // Catch: java.lang.Throwable -> L1c0
            java.lang.Long r0 = r12.parseRetryAfterMillis(r0)     // Catch: java.lang.Throwable -> L1c0
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L1c0
            kotlin.p007io.CloseableKt.closeFinally(r10, r15)     // Catch: java.lang.Throwable -> L1cc
            r1.sleepBeforeRetry(r13, r0)     // Catch: java.lang.Throwable -> L1cc
            r0 = r16
            r2 = 0
            goto L1e6
        L1af:
            r14 = 2
            com.filmkio.nativescreen.net.FkApiClient$ApiException r12 = new com.filmkio.nativescreen.net.FkApiClient$ApiException     // Catch: java.lang.Throwable -> L1c0
            int r0 = r0.code()     // Catch: java.lang.Throwable -> L1c0
            r15 = 350(0x15e, float:4.9E-43)
            java.lang.String r2 = kotlin.text.StringsKt.take(r2, r15)     // Catch: java.lang.Throwable -> L1c0
            r12.<init>(r0, r2)     // Catch: java.lang.Throwable -> L1c0
            throw r12     // Catch: java.lang.Throwable -> L1c0
        L1c0:
            r0 = move-exception
            goto L1c4
        L1c2:
            r0 = move-exception
            r14 = 2
        L1c4:
            r2 = r0
        L1c5:
            throw r2     // Catch: java.lang.Throwable -> L1c6
        L1c6:
            r0 = move-exception
            r12 = r0
            kotlin.p007io.CloseableKt.closeFinally(r10, r2)     // Catch: java.lang.Throwable -> L1cc
            throw r12     // Catch: java.lang.Throwable -> L1cc
        L1cc:
            r0 = move-exception
            goto L1d0
        L1ce:
            r0 = move-exception
            r14 = 2
        L1d0:
            boolean r2 = r1.isLikelyTlsIssue(r0)
            if (r2 == 0) goto L1dc
            com.filmkio.nativescreen.net.FkNetworkCompat r2 = com.filmkio.nativescreen.net.FkNetworkCompat.INSTANCE
            r10 = 0
            r2.refreshSecurityProvider(r10)
        L1dc:
            boolean r2 = r1.shouldRetryThrowable(r0, r9, r13, r11)
            if (r2 == 0) goto L1f0
            r2 = 0
            r1.sleepBeforeRetry(r13, r2)
        L1e6:
            if (r13 == r11) goto L1ee
            int r13 = r13 + 1
            r2 = r19
            goto L4e
        L1ee:
            r12 = r0
            goto L1f3
        L1f0:
            throw r0
        L1f1:
            r2 = 0
            r12 = r2
        L1f3:
            if (r12 != 0) goto L1ff
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r2 = "NETWORK_RETRY_EXHAUSTED"
            r0.<init>(r2)
            r12 = r0
            java.lang.Throwable r12 = (java.lang.Throwable) r12
        L1ff:
            throw r12
    }
