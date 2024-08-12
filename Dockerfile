# Используем базовый образ
FROM alpine:3.12 AS builder

# Создаем рабочую директорию
WORKDIR /app

# Создаем простой файл для примера
RUN echo "Hello, World!" > hello.txt

# Создаем архив из файла
RUN tar -czvf hello.tar.gz hello.txt

# Финальный образ без изменений
FROM alpine:3.12

# Копируем архив из предыдущего этапа в финальный образ
COPY --from=builder /app/hello.tar.gz /app/

CMD ["cat", "/app/hello.txt"]

