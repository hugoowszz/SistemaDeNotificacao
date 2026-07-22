INSERT INTO canais_comunicacao (nome) VALUES ('EMAIL');
INSERT INTO canais_comunicacao (nome) VALUES ('SMS');
INSERT INTO canais_comunicacao (nome) VALUES ('PUSH');

INSERT INTO usuarios (nome, email) VALUES ('Ana Silva', 'ana@email.com');
INSERT INTO usuarios (nome, email) VALUES ('Carlos Souza', 'carlos@email.com');
INSERT INTO usuarios (nome, email) VALUES ('Maria Oliveira', 'maria@email.com');

INSERT INTO usuario_canal (usuario_id, canal_id) VALUES (1, 1); -- Ana prefere Email
INSERT INTO usuario_canal (usuario_id, canal_id) VALUES (1, 2); -- Ana prefere SMS
INSERT INTO usuario_canal (usuario_id, canal_id) VALUES (2, 2); -- Carlos prefere SMS
INSERT INTO usuario_canal (usuario_id, canal_id) VALUES (3, 3); -- Maria prefere Push

INSERT INTO recibos_notificacao (usuario_id, destinatario, canal, mensagem, sucesso)
VALUES (1, 'ana@email.com', 'NotificacaoEmail', 'Compra de R$ 150.00 aprovada!', true);

INSERT INTO recibos_notificacao (usuario_id, destinatario, canal, mensagem, sucesso)
VALUES (1, '11999998888', 'NotificacaoSms', 'Transação PIX concluída', true);

INSERT INTO recibos_notificacao (usuario_id, destinatario, canal, mensagem, sucesso)
VALUES (2, '9999-9999', 'NotificacaoSms', 'Sua senha foi alterada', false);

INSERT INTO recibos_notificacao (usuario_id, destinatario, canal, mensagem, sucesso)
VALUES (3, 'token-maria-123', 'NotificacaoPush', 'Novidades no seu app!', true);