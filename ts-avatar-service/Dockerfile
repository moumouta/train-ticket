FROM python:3.8.17-slim-bullseye

RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone

RUN echo "deb https://mirrors.ustc.edu.cn/debian/ bullseye main contrib non-free\n\
deb-src https://mirrors.ustc.edu.cn/debian/ bullseye main contrib non-free\n\
deb https://mirrors.ustc.edu.cn/debian/ bullseye-updates main contrib non-free\n\
deb-src https://mirrors.ustc.edu.cn/debian/ bullseye-updates main contrib non-free\n\
deb https://mirrors.ustc.edu.cn/debian/ bullseye-backports main contrib non-free\n\
deb-src https://mirrors.ustc.edu.cn/debian/ bullseye-backports main contrib non-free\n\
deb https://mirrors.ustc.edu.cn/debian-security/ bullseye-security main contrib non-free\n\
deb-src https://mirrors.ustc.edu.cn/debian-security/ bullseye-security main contrib non-free" > /etc/apt/sources.list


RUN apt update -y
RUN apt install -y cmake libgl1-mesa-glx build-essential libglib2.0-0

ENV PYTHONUNBUFFERED=TRUE

RUN mkdir -p /app
ADD . /app/
WORKDIR /app

RUN pip config set global.index-url https://pypi.tuna.tsinghua.edu.cn/simple
RUN pip install -r requirements.txt

CMD ["gunicorn", "-w", "4", "-b", "0.0.0.0:8080", "app:app"]

EXPOSE 8080
