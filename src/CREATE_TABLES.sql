-- ī�װ� �����̼�
CREATE TABLE ī�װ� (
    ī�װ��� VARCHAR2(100) PRIMARY KEY
);

-- �а� �����̼�
CREATE TABLE �а� (
    �а��� VARCHAR2(100) UNIQUE,
    �а���ȣ NUMBER PRIMARY KEY
);

-- �л� �����̼�
CREATE TABLE �л� (
    �й� NUMBER PRIMARY KEY,
    �а���ȣ NUMBER,
    ��й�ȣ VARCHAR2(100) NOT NULL,
    �̸� VARCHAR2(100) NOT NULL,
    �Խñ۵�ϼ� NUMBER DEFAULT 0,
    �������� DATE DEFAULT SYSDATE,
    CONSTRAINT fk_�л�_�а� FOREIGN KEY (�а���ȣ) REFERENCES �а�(�а���ȣ)
);

-- ��ǰ �Խñ� �����̼�
CREATE TABLE ��ǰ_�Խñ� (
    �Խñ۹�ȣ NUMBER PRIMARY KEY,
    �й� NUMBER,
    �а��� VARCHAR2(100),
    ī�װ��� VARCHAR2(100),
    �ŷ��� NUMBER,
    �ŷ��ݾ� NUMBER,
    ��ǰ�� VARCHAR2(200),
    ��ǰ���� VARCHAR2(1000),
    �ŷ����� VARCHAR2(10) ,
    ��ϳ�¥ DATE DEFAULT SYSDATE,
    CONSTRAINT fk_��ǰ_�Խñ�_�л� FOREIGN KEY (�й�) REFERENCES �л�(�й�),
    CONSTRAINT fk_��ǰ_�Խñ�_�а� FOREIGN KEY (�а���) REFERENCES �а�(�а���),
    CONSTRAINT fk_��ǰ_�Խñ�_ī�װ� FOREIGN KEY (ī�װ���) REFERENCES ī�װ�(ī�װ���),
    CONSTRAINT fk_��ǰ_�Խñ�_�ŷ��� FOREIGN KEY (�ŷ���) REFERENCES �л�(�й�)
    
);

-- ���ã�� [����] �����̼�
CREATE TABLE ���ã�� (
    �й� NUMBER,
    �Խñ۹�ȣ NUMBER,
    PRIMARY KEY (�й�, �Խñ۹�ȣ),
    CONSTRAINT fk_���ã��_�л� FOREIGN KEY (�й�) REFERENCES �л�(�й�),
    CONSTRAINT fk_���ã��_��ǰ FOREIGN KEY (�Խñ۹�ȣ) REFERENCES ��ǰ_�Խñ�(�Խñ۹�ȣ)
);

-- ���� [����] �����̼�
CREATE TABLE ���� (
    ������ȣ NUMBER PRIMARY KEY,
    �й� NUMBER,
    �Խñ۹�ȣ NUMBER,
    ��ǰ�Խñ� VARCHAR2(200),
    ���� VARCHAR2(200),
    ���� VARCHAR2(1000),
    �������� DATE DEFAULT SYSDATE,
    CONSTRAINT fk_����_�л� FOREIGN KEY (�й�) REFERENCES �л�(�й�),
    CONSTRAINT fk_����_��ǰ FOREIGN KEY (�Խñ۹�ȣ) REFERENCES ��ǰ_�Խñ�(�Խñ۹�ȣ)
);

