FROM scratch
COPY target/com.education.springnidemo.springnidemoapplication /app
ENTRYPOINT ["/app"]