ALTER TABLE `invoice_records`
    ADD UNIQUE INDEX `唯一` (`ticket_code`, `ticket_number`);